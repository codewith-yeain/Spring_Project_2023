package com.app.icontact.controller;

import com.app.icontact.domain.UserVO;
import com.app.icontact.exception.LoginFailedException;
import com.app.icontact.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

//    회원가입
    @GetMapping("join")
    public void goToJoinForm(UserVO userVO){;}

    @PostMapping("join")
    public RedirectView join(UserVO userVO){
        userService.join(userVO);
        log.info("{}..........", userVO.toString());
        return new RedirectView("/user/login");
    }

//    로그인
    @GetMapping("login")
    public void login(UserVO userVO){;}

    @PostMapping("login")
    public RedirectView login(UserVO userVO, HttpSession session){
        session.setAttribute("id", userService.login(userVO).orElseThrow(() -> {throw new LoginFailedException("아이디 또는 비밀번호 오류");}));
        log.info("{}..........", session.getAttribute("id"));
        return new RedirectView("/icontact/");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/icontact/");
    }

//    이메일 중복검사
    @GetMapping("/check-email")
    @ResponseBody
    public boolean checkEmail(String userEmail){
    return userService.checkEmail(userEmail).isPresent();
}

}

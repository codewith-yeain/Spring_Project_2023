package com.app.icontact.controller;

import com.app.icontact.domain.UserVO;
import com.app.icontact.exception.LoginFailedException;
import com.app.icontact.service.MailService;
import com.app.icontact.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;
    private final MailService mailService;

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
    @GetMapping("check-email")
    @ResponseBody
    public boolean checkEmail(String userEmail){
    return userService.checkEmail(userEmail).isPresent();
}

    //    닉네임 중복검사
    @GetMapping("check-nickname")
    @ResponseBody
    public boolean checkNickname(String userNickname){
        return userService.checkNickname(userNickname).isPresent();
    }

    // 이메일 인증 번호
    @GetMapping("email-auth")
    public void goToEmailAuth(String toEmail){;}

    @ResponseBody
    @PostMapping("email-auth")
    public String MailSend(String toEmail) throws UnsupportedEncodingException, MessagingException {
        String authCode = mailService.sendEmail(toEmail);
        return authCode;
    }

    // 로그아웃 상태에서 비밀번호 변경
    @GetMapping("change-password")
    public String goToChangePasswordForm(@RequestParam("userEmail") String userEmail, Model model) {
        // userEmail 값을 Model에 추가하여 뷰에서 사용할 수 있게 합니다.
        model.addAttribute("userEmail", userEmail);
        // 비밀번호 변경 페이지 뷰 이름을 반환합니다.
        // (예: "changePassword"는 실제 뷰 파일 이름이 될 것입니다. 예: changePassword.html)
        return "user/change-password";
    }

    @PostMapping("change-password")
    public RedirectView changePassword(String userEmail, String userPassword, RedirectAttributes redirectAttributes){
        userService.changePassword(userEmail, userPassword);
        return new RedirectView("/user/login");
    }

    @GetMapping("find-password")
    public void goToFindPasswordForm(UserVO userVO){;}
}

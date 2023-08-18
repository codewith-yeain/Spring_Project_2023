package com.app.icontact.controller;

import com.app.icontact.domain.MemberVO;
import com.app.icontact.exception.LoginFailedException;
import com.app.icontact.service.MemberService;
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
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;

//    회원가입
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO){;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberService.join(memberVO);
        return new RedirectView("/member/login");
    }

//    로그인
    @GetMapping("login")
    public void login(MemberVO memberVO){;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session){
        session.setAttribute("Id", memberService.login(memberVO).orElseThrow(() -> {throw new LoginFailedException("아이디 또는 비밀번호 오류");}));
        return new RedirectView("/main/main");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/main/main");
    }

//    이메일 중복검사
    @GetMapping("/check-email")
    @ResponseBody
    public boolean checkEmail(String memberEmail){
    return memberService.checkEmail(memberEmail).isPresent();
}

}

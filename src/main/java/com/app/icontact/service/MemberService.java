package com.app.icontact.service;

import com.app.icontact.domain.MemberVO;

import java.util.Optional;

public interface MemberService {

//        회원 가입
    public void join(MemberVO memberVO);

//    로그인
    public Optional<String> login(MemberVO memberVO);

//    이메일 중복 검사
    public Optional<String> checkEmail(String memberEmail);
}

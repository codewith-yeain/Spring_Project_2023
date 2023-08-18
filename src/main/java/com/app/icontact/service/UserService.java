package com.app.icontact.service;

import com.app.icontact.domain.UserVO;

import java.util.Optional;

public interface UserService {

//        회원 가입
    public void join(UserVO userVO);

//    로그인
    public Optional<String> login(UserVO userVO);

//    이메일 중복 검사
    public Optional<String> checkEmail(String memberEmail);
}

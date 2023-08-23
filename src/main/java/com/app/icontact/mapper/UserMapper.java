package com.app.icontact.mapper;

import com.app.icontact.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//    회원 가입
    public void insert(UserVO userVO);

//        로그인
    public String selectId(UserVO userVO);

//        이메일 중복검사
    public String selectForEmailCheck(String userEmail);

//    닉네임 중복검사
    public String selectForNicknameCheck(String userNickname);


}

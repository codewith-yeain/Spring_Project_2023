package com.app.icontact.mapper;

import com.app.icontact.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
//    회원 가입
    public void insert(MemberVO memberVO);

//        로그인
    public String selectId(MemberVO memberVO);

//        이메일 중복검사
    public String selectForEmailCheck(String memberId);


}

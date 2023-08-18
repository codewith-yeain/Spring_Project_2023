package com.app.icontact.DAO;

import com.app.icontact.domain.MemberVO;
import com.app.icontact.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    회원가입
    public void save(MemberVO memberVO){
    memberMapper.insert(memberVO);
}

//    로그인
    public String findIdByMemberEmailAndMemberPassword(MemberVO memberVO){ return memberMapper.selectId(memberVO); };

//    이메일 중복검사
    public String findMemberEmailByMemberEmail(String memberEmail){
        return memberMapper.selectForEmailCheck(memberEmail);
    }

}

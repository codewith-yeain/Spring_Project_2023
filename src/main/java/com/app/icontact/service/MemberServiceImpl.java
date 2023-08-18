package com.app.icontact.service;

import com.app.icontact.DAO.MemberDAO;
import com.app.icontact.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

//    회원가입
    @Override
    public void join(MemberVO memberVO) { memberDAO.save(memberVO); }

//    로그인
    @Override
    public Optional<String> login(MemberVO memberVO) {
        return Optional.ofNullable(memberDAO.findIdByMemberEmailAndMemberPassword(memberVO));
    }

//    이메일 중복 검사
    @Override
    public Optional<String> checkEmail(String memberEmail) {
        return Optional.ofNullable(memberDAO.findMemberEmailByMemberEmail(memberEmail));
    }
}

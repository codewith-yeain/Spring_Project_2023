package com.app.icontact.DAO;

import com.app.icontact.domain.UserVO;
import com.app.icontact.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

//    회원가입
    public void save(UserVO userVO){
    userMapper.insert(userVO);
}

//    로그인
    public String findIdByUserEmailAndUserPassword(UserVO userVO){ return userMapper.selectId(userVO); };

//    이메일 중복검사
    public String findUserEmailByUserEmail(String userEmail){
        return userMapper.selectForEmailCheck(userEmail);
    }

    //    닉네임 중복검사
    public String findUserNicknameByUserNickname(String userNickname){
        return userMapper.selectForNicknameCheck(userNickname);
    }

    // 비밀번호 변경
    public void changePasswordByUserEmailAndUserPassword(String userEmail, String userPassword){
        userMapper.updatedPassword(userEmail, userPassword);
    }

    //    회원 조회
    public Optional<UserVO> findById(Long id){
        return userMapper.selectById(id);
    }


}

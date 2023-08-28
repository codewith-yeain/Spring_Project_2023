package com.app.icontact.service;

import com.app.icontact.DAO.UserDAO;
import com.app.icontact.domain.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

//    회원가입
    @Override
    public void join(UserVO userVO) { userDAO.save(userVO); }

//    로그인
    @Override
    public Optional<String> login(UserVO userVO) {
        return Optional.ofNullable(userDAO.findIdByUserEmailAndUserPassword(userVO));
    }

//    이메일 중복 검사
    @Override
    public Optional<String> checkEmail(String userEmail) {
        return Optional.ofNullable(userDAO.findUserEmailByUserEmail(userEmail));
    }

//    닉네임 중복검사
    @Override
    public Optional<String> checkNickname(String userNickname) {
        return Optional.ofNullable(userDAO.findUserNicknameByUserNickname(userNickname));
    }

//    비밀번호 변경
    @Override
    public void changePassword(String userEmail, String userPassword) {
        userDAO.changePasswordByUserEmailAndUserPassword(userEmail, userPassword);
    }

    @Override
    public Optional<UserVO> getUser(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void changePasswordWhileLogin(Long id, String userPassword) {
        userDAO.changePasswordByUserIdAndUserPassword(id, userPassword);
    }
}

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
}

package com.app.icontact.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectNicknameTests(){
        log.info("{}............", userMapper.selectForNicknameCheck("예인"));
    }

    @Test
    public void updatedPasswordTests(){
        userMapper.updatedPassword("eunyoung.choi@email.com", "young");
    }
}













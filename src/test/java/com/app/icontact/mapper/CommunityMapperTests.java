package com.app.icontact.mapper;

import com.app.icontact.DTO.CommunityDTO2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityMapperTests {
    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void selectTests(){
        communityMapper.selectListByReadCount().stream().map(CommunityDTO2::toString).forEach(log::info);
    }
}

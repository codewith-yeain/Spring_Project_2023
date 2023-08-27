package com.app.icontact.service;

import com.app.icontact.DTO.CommunityDTO;
import com.app.icontact.domain.CommunityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityServiceTests {

    @Autowired
    private CommunityService communityService;


    @Test
    public void getListComAllTests(){
        communityService.getListComAll().stream().map(CommunityDTO::toString).forEach(log::info);
    }


    @Test
    public void getListComMineTests(){
        communityService.getListComMine(2L).stream().map(CommunityVO::toString).forEach(log::info);
    }


}

package com.app.icontact.mapper;

import com.app.icontact.DTO.CommunityDTO;
import com.app.icontact.DTO.CommunityDTO2;
import com.app.icontact.domain.CommunityVO;
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

    @Test
    public void selectComAllTests(){
        communityMapper.selectComAll().stream().map(CommunityDTO::toString).forEach(log::info);
    }

    @Test
    public void selectComMineTests(){
        communityMapper.selectComMine(2L).stream().map(CommunityVO::toString).forEach(log::info);
    }


}

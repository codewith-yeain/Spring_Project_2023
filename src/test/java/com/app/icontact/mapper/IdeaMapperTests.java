package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class IdeaMapperTests {
    @Autowired
    private IdeaMapper ideaMapper;

    @Test
    public void selectByReadCountTests(){
        ideaMapper.selectByIdeaCategory(1L).stream().map(IdeaDTO2::toString).forEach(log::info);
    }

    @Test
    public void selectByIdeaCategoryTests(){
        ideaMapper.selectPremiumIdeaByIdeaCategory(1L).stream().map(IdeaDTO2::toString).forEach(log::info);
    }

    @Test
    public void selectByScrapTests(){
        ideaMapper.selectByScrap().stream().map(IdeaDTO2::toString).forEach(log::info);
    }
}

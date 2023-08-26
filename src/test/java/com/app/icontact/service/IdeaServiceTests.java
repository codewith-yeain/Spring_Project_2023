package com.app.icontact.service;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.mapper.IdeaMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class IdeaServiceTests {
    @Autowired
    private IdeaService ideaService;

    @Test
    public void selectByReadCountTests(){
        ideaService.getMostReadIdeas(1L).stream().map(IdeaDTO2::toString).forEach(log::info);
    }

    @Test
    public void selectTests(){
        ideaService.getPremiumIdeas(1L).stream().map(IdeaDTO2::toString).forEach(log::info);
    }

//    @Test
//    public void writeTests(){
//
//    }

}

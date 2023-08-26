package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;
import com.app.icontact.DTO.IdeaDTO4;
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
        ideaMapper.selectByScrap().stream().map(IdeaDTO3::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        IdeaDTO4 ideaDTO4 = new IdeaDTO4();
        ideaDTO4.setUserId(82L);
        ideaDTO4.setIdeaTitle("들어갔으면 좋겠다");
        ideaDTO4.setIdeaIntro("한줄소개 ~");
        ideaDTO4.setIdeaDetail("상세설명 ~");
        ideaDTO4.setIdeaCategory(2L);
        ideaDTO4.setIdeaType("프리미엄");
        ideaDTO4.setIdeaPrice(20000L);
        ideaDTO4.setIdeaMax(9L);
        ideaMapper.insert(ideaDTO4);
    }

    @Test
    public void selectIdeasTest(){
        Long ideaCategory = null;
        ideaMapper.selectIdeas(ideaCategory).stream().map(IdeaDTO4::toString).forEach(log::info);
    }
}

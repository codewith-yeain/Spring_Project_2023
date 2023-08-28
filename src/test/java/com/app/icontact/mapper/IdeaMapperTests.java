package com.app.icontact.mapper;

import com.app.icontact.DTO.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void selectCountOfScrapsTests(){
        log.info("{}...............", ideaMapper.selectCountOfScraps(95L));
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
    public void testSelectIdeas() {
        Search search = new Search();
        // 필요한 검색 조건을 설정. 예를 들어:
        search.setIdeaCategory(1L);
        search.setIdeaPrice(6L);
        // 다른 필터링 조건들도 설정 가능.

        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setRowCount(10);

        List<IdeaDTO4> ideas = ideaMapper.selectIdeas(search, pagination);

//        assertNotNull(ideas); // 결과가 null이 아닌지 검사.
//        assertTrue(ideas.size() > 0); // 결과가 하나 이상인지 검사.

        // log.info를 사용하여 테스트 결과 로그 출력
//        log.info("Fetched {} ideas.", ideas.size());
        for(IdeaDTO4 idea : ideas) {
            log.info(idea.toString());
        }
    }

    @Test
    public void testSelectCountOfIdeas() {
        Search search = new Search();
        // 필요한 검색 조건을 설정. 예를 들어:
        search.setIdeaCategory(1L);
        search.setIdeaPrice(6L);
        // 다른 필터링 조건들도 설정 가능.

        int count = ideaMapper.selectCountOfIdeas(search);
        log.info("{}.......", count);
//        assertTrue(count > 0); // 결과가 0보다 큰지 검사.
    }
}

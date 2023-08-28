package com.app.icontact.service;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO4;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.DTO.Search;
import com.app.icontact.mapper.IdeaMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void selectListTests() {
        // 1. Pagination 객체 초기화
        Pagination pagination = new Pagination();


        // 2. Search 객체 초기화 및 설정
        Search search = new Search();
        search.setIdeaCategory(1L); // 여성의류 카테고리를 가정
        search.setIdeaPrice(6L);
        // 임시로 total 값을 설정 (실제로는 DB에서 얻어온 총 데이터의 수가 되어야 합니다)
        pagination.setTotal(ideaService.getTotal(search)); // 예를 들면 총 120개의 아이디어가 있다고 가정
        pagination.progress(); // Pagination 객체 내부의 필요한 값들을 계산


        // 필요한 경우 다른 search 필드도 설정 가능

        // 3. getList 메서드 호출 및 결과 로그 출력
        List<IdeaDTO4> ideas = ideaService.getList(pagination, search);
        ideas.stream().map(IdeaDTO4::toString).forEach(log::info);
    }


    @Test
    public void selectTotalTests() {
        // 2. Search 객체 초기화 및 설정
        Search search = new Search();
        search.setIdeaCategory(1L); // 여성의류 카테고리를 가정
        search.setIdeaPrice(6L);
        // 필요한 경우 다른 search 필드도 설정 가능

        // 3. getList 메서드 호출 및 결과 로그 출력
        int total = ideaService.getTotal(search);
        log.info("{}........", total);
    }

}

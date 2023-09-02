package com.app.icontact.mapper;

import com.app.icontact.DTO.*;
import com.app.icontact.domain.IdeaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IdeaMapper {

    // 조회수 상위 4개 아이디어 조회
    public List<IdeaDTO4> selectByIdeaCategory(Long ideaCategory);

    // 프리미엄 아이디어 랜덤 4개 조회
    public List<IdeaDTO4> selectPremiumIdeaByIdeaCategory(Long ideaCategory);

    // 스크랩수 상위 4개 조회
    public List<IdeaDTO4> selectByScrap();

    // 아이디어 추가
    public void insert(IdeaDTO4 ideaDTO4);

    // 아이디어 뱅크 목록 출력
    public List<IdeaDTO4> selectIdeas(@Param("search") Search search, @Param("pagination") Pagination pagination);

    //    아이디어 총 개수
    public int selectCountOfIdeas(@Param("search") Search search);

    // 해당 아이디어의 총 스크랩수
    public Long selectCountOfScraps(Long ideaId);

    // 아이디어 1개 조회
    public Optional<IdeaDTO5> select(Long id);

    // 조회수 증가
    public void updateReadCount(Long id);

    // 특정 아이디어의 협의완료 수
    public Long selectFinishUserCountOfIdea(Long id);

    // 특정 유저의 아이디어 조회
    public List<IdeaDTO4> selectIdeasByUserId(Long userId);

    // 특정 유저가 등록한 아이디어의 총 개수
    public int selectCountOfIdeasByUserId(Long userId);

    // 아이디어 검색
    public List<IdeaDTO4> search(String keyword);

}

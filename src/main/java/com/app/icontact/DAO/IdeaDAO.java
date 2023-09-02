package com.app.icontact.DAO;

import com.app.icontact.DTO.*;
import com.app.icontact.mapper.IdeaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IdeaDAO {
    private final IdeaMapper ideaMapper;

    // 조회수 상위 4개 아이디어 조회
    public List<IdeaDTO4> findMostReadIdeasByIdeaCategory(Long ideaCategory){
        return ideaMapper.selectByIdeaCategory(ideaCategory);
    }

    // 프리미엄 아이디어 랜덤 4개 조회
    public List<IdeaDTO4> findPremiumIdeaByIdeaCategory(Long ideaCategory){
        return ideaMapper.selectPremiumIdeaByIdeaCategory(ideaCategory);
    }

    // 스크랩수 상위 4개 조회
    public List<IdeaDTO4> findIdeaByScrap(){
        return ideaMapper.selectByScrap();
    }

    //    아이디어 추가
    public void save(IdeaDTO4 ideaDTO4){
        ideaMapper.insert(ideaDTO4);
    }

    //    아이디어 목록
    public List<IdeaDTO4> findAll(Search search, Pagination pagination){
        return ideaMapper.selectIdeas(search, pagination);
    }

    //    게시글 총 개수
    public int findCountOfIdeas(Search search){
        return ideaMapper.selectCountOfIdeas(search);
    }

    // 해당 아이디어의 총 스크랩수
    public Long findCountOfScraps(Long ideaId){
        return ideaMapper.selectCountOfScraps(ideaId);
    }

    // 아이디어 1개 조회
    public Optional<IdeaDTO5> findById(Long id){
        return ideaMapper.select(id);
    }

    // 조회수 증가
    public void updateReadCount(Long id){
        ideaMapper.updateReadCount(id);
    }

    // 특정 아이디어의 협의완료 수
    public Long findFinishUserCountOfIdea(Long id){
        return ideaMapper.selectFinishUserCountOfIdea(id);
    }

    // 특정 유저의 아이디어 조회
    public List<IdeaDTO4> findIdeasByUserId(Long userId){
        return ideaMapper.selectIdeasByUserId(userId);
    }

    // 특정 유저가 등록한 아이디어의 총 개수
    public int getCountOfIdeasByUserId(Long userId){
        return ideaMapper.selectCountOfIdeasByUserId(userId);
    }

    // 아이디어 검색
    public List<IdeaDTO4> findIdea(String keyword){
        return ideaMapper.search(keyword);
    }

}

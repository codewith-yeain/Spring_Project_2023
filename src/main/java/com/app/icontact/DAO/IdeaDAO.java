package com.app.icontact.DAO;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;
import com.app.icontact.mapper.IdeaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IdeaDAO {
    private final IdeaMapper ideaMapper;

    // 조회수 상위 4개 아이디어 조회
    public List<IdeaDTO2> findMostReadIdeasByIdeaCategory(Long ideaCategory){
        return ideaMapper.selectByIdeaCategory(ideaCategory);
    }

    // 프리미엄 아이디어 랜덤 4개 조회
    public List<IdeaDTO2> findPremiumIdeaByIdeaCategory(Long ideaCategory){
        return ideaMapper.selectPremiumIdeaByIdeaCategory(ideaCategory);
    }

    // 조회수 상위 4개 조회
    public List<IdeaDTO3> findIdeaByScrap(){
        return ideaMapper.selectByScrap();
    }

}

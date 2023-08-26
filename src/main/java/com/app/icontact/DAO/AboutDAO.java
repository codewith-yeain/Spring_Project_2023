package com.app.icontact.DAO;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.mapper.AboutMapper;
import com.app.icontact.mapper.IdeaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AboutDAO {
    private final AboutMapper aboutMapper;
    private IdeaMapper ideaMapper;

    // 조회수 상위 4개 아이디어 조회
    public List<IdeaDTO2> findMostReadIdeasByIdeaCategory(Long ideaCategory){
        return ideaMapper.selectByIdeaCategory(ideaCategory);
    }
}

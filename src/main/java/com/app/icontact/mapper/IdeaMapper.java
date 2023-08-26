package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;
import com.app.icontact.DTO.IdeaDTO4;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IdeaMapper {

    // 조회수 상위 4개 아이디어 조회
    public List<IdeaDTO2> selectByIdeaCategory(Long ideaCategory);

    // 프리미엄 아이디어 랜덤 4개 조회
    public List<IdeaDTO2> selectPremiumIdeaByIdeaCategory(Long ideaCategory);

    // 스크랩수 상위 4개 조회
    public List<IdeaDTO3> selectByScrap();

    // 아이디어 추가
    public void insert(IdeaDTO4 ideaDTO4);

    public List<IdeaDTO4> selectIdeas(Long ideaCategory);

}

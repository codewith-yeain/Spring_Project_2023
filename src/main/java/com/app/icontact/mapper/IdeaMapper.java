package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IdeaMapper {

    // 조회수 상위 4개 아이디어 조회
    public List<IdeaDTO2> selectByIdeaCategory(Long ideaCategory);

    // 프리미엄 아이디어 랜덤 4개 조회
    public List<IdeaDTO2> selectPremiumIdeaByIdeaCategory(Long ideaCategory);

}

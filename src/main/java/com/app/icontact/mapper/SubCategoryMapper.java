package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.domain.IdeaCategoryNames;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubCategoryMapper {

    // 하위 분야 이름 조회
    public String selectIdeaSubCategoryNameByIdeaCategory(Long id);

    // 특정 유저의 관심 분야 이름 조회
    public List<String> selectSubCategoryName(Long id);

    // 특정 아이디어가 소속된 상위 및 하위 분야 이름 조회
    public IdeaCategoryNames selectSubCategoryNameAndTopCategoryNameByIdeaId(Long id);
}

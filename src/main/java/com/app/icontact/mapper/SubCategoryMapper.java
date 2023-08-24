package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubCategoryMapper {

    // 하위 분야 이름 조회
    public String selectIdeaSubCategoryNameByIdeaCategory(Long id);
}

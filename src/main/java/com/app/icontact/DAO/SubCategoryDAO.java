package com.app.icontact.DAO;

import com.app.icontact.mapper.SubCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubCategoryDAO {
    private final SubCategoryMapper subCategoryMapper;

    // 하위 분야 이름 조회
    public String findName(Long id){
        return subCategoryMapper.selectIdeaSubCategoryNameByIdeaCategory(id);
    }
}

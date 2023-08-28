package com.app.icontact.DAO;

import com.app.icontact.domain.IdeaCategoryNames;
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

    // 특정 유저의 관심 분야 이름 조회
    public List<String> findSubCategoryName(Long id){
        return subCategoryMapper.selectSubCategoryName(id);
    }

    // 특정 아이디어가 소속된 상위 및 하위 분야 이름 조회
    public IdeaCategoryNames findSubCategoryNameAndTopCategoryNameByIdeaId(Long id){
        return subCategoryMapper.selectSubCategoryNameAndTopCategoryNameByIdeaId(id);
    }
}

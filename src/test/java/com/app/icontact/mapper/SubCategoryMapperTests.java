package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SubCategoryMapperTests {
    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Test
    public void selectByReadCountTests(){
        log.info("{}................", subCategoryMapper.selectIdeaSubCategoryNameByIdeaCategory(1L));
    }
}

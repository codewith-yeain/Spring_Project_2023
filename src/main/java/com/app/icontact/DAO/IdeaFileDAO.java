package com.app.icontact.DAO;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;
import com.app.icontact.DTO.IdeaDTO4;
import com.app.icontact.domain.IdeaFileVO;
import com.app.icontact.mapper.IdeaFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IdeaFileDAO {
    private final IdeaFileMapper ideaFileMapper;

    //    파일 추가
    public void save(IdeaFileVO ideaFileVO){
        ideaFileMapper.insert(ideaFileVO);
    }

}

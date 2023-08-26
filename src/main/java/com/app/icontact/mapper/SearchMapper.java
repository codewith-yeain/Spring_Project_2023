package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO;
import com.app.icontact.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    // 유저 검색결과
    public List<UserDTO> selectUserNickname (String userNickname);

    // 아이디어 검색결과
    public List<IdeaDTO> selectIdeaTitle (String ideaTitle);

}

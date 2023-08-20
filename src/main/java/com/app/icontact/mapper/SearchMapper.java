package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO;
import com.app.icontact.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    //검색결과 모두보기

    //모두보기 유저 검색결과
    public List<UserDTO> selectUserNickname (String userNickname);

    //모두보기 아이디어 검색결과
    public List<IdeaDTO> selectIdeaTitle (String ideaTitle);

    //유저 검색결과

    //아이디어 검색결과
}

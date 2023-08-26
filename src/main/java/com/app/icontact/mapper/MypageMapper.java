package com.app.icontact.mapper;

import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {

//    회원 정보 조회 (회원 정보 가져오기)
    public UserVO selectUser(Long id);

//    내 아아디어들 전부 가져오기
    public List<IdeaVO> selectAllMyIdea(Long id);






}

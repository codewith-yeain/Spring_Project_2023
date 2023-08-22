package com.app.icontact.mapper;

import com.app.icontact.domain.CommunityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {
    //    listMine 커뮤니티 내 게시글 목록
    public List<CommunityVO> selectComMine(Long id);

//    커뮤니티 게시글 작성
    public void insertCom(CommunityVO communityVO);



//        listAll 커뮤니티 내 모든 게시글 목록
    public List<CommunityVO> selectComAll();

//





}

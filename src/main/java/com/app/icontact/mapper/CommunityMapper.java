package com.app.icontact.mapper;

import com.app.icontact.domain.CommunityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityMapper {
    //    listMine 커뮤니티 내 게시글 목록
    public List<CommunityVO> selectComMine(Long id);
}

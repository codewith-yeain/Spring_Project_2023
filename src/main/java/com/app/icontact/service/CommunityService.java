package com.app.icontact.service;

import com.app.icontact.domain.CommunityVO;

import java.util.List;

public interface CommunityService {
    //    listMine 커뮤니티 내 게시글 목록
    public List<CommunityVO> selectComMine(Long id);
}

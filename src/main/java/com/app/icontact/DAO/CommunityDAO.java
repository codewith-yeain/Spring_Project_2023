package com.app.icontact.DAO;

import com.app.icontact.domain.CommunityVO;
import com.app.icontact.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Slf4j
public class CommunityDAO {
    private final CommunityMapper communityMapper;

//    listMine 에서의 목록 불러오기
    public List<CommunityVO> findComMine(Long id) {
        return communityMapper.selectComMine(id);
    }

    //    커뮤니티 게시글 작성
    public void saveCom(CommunityVO communityVO){
        communityVO.setUserId(21L);
        log.info("{}..........", communityVO.toString());
        communityMapper.insertCom(communityVO);
    }

    //        listAll 커뮤니티 내 모든 게시글 목록
    public List<CommunityVO> findComAll(){
        return communityMapper.selectComAll();
    }

}

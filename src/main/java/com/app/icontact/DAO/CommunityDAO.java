package com.app.icontact.DAO;

<<<<<<< HEAD
import com.app.icontact.DTO.CommunityDTO;
=======
import com.app.icontact.DTO.CommunityDTO2;
>>>>>>> master
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
        log.info("{}..........", communityVO.toString());
        communityMapper.insertCom(communityVO);
    }

    //        listAll 커뮤니티 내 모든 게시글 목록
    public List<CommunityDTO> findComAll(){
        return communityMapper.selectComAll();
    }

    // 조회수 상위 3개 조회
    public List<CommunityDTO2> findCommunityByReadCount(){
        return communityMapper.selectListByReadCount();
    }
}

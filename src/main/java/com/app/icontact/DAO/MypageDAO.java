package com.app.icontact.DAO;

import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import com.app.icontact.mapper.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageDAO {
    private final MypageMapper mypageMapper;

    //    회원 정보 조회 (회원 정보 가져오기)
    public UserVO findUser(Long id){
        return mypageMapper.selectUser(id);
    }

    //    내 아아디어들 전부 가져오기
    public List<IdeaVO> findAllMyIdea(Long id){
        return mypageMapper.selectAllMyIdea(id);
    }

}

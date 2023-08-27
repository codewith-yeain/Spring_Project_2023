package com.app.icontact.service;

import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;

import java.util.List;

public interface MypageService {

    //    회원 정보 조회 (회원 정보 가져오기)
    public UserVO getUser(Long id);

    //    내 아아디어들 전부 가져오기
    public List<IdeaVO> getAllMyIdea(Long id);


}

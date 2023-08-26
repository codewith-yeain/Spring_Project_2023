package com.app.icontact.service;

import com.app.icontact.DAO.MypageDAO;
import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDAO mypageDAO;
    private final HttpSession session;

    @Override
    public UserVO getUser(Long id) {
        return mypageDAO.findUser(2L);
    }


    @Override
    public List<IdeaVO> getAllMyIdea(Long id) {


        Long userId = (Long) session.getAttribute("userId");
        return mypageDAO.findAllMyIdea(userId);
    }
}

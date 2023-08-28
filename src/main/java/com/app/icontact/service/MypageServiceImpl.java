package com.app.icontact.service;

import com.app.icontact.DAO.MypageDAO;
import com.app.icontact.DTO.BusinessDTO;
import com.app.icontact.domain.BusinessVO;
import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDAO mypageDAO;
    private final HttpSession session;

    @Override
    public UserVO getUser(Long id) {
//        Long userId = (Long) session.getAttribute("id");
//        Long userId = (Long) session.getAttribute("id");

        log.info("{}..........", session.getAttribute("id"));
//        log.info("{}..........", userId);

//        return mypageDAO.findUser(47L);
        return mypageDAO.findUser(id);
    }


    @Override
    public List<IdeaVO> getAllMyIdea(Long id) {
        Long userId = (Long) session.getAttribute("id");
        return mypageDAO.findAllMyIdea(userId);
    }


    @Override
    public void modifyUserInfo(UserVO userVO) {

        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
        userVO.setId(userId);
        log.info("{}..........{}.......{}", session.getAttribute("id"), userVO, userId);
        mypageDAO.changeUserInfo(userVO);
    }

    @Override
    public void writeBusinessRegister(BusinessVO businessVO) {
        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
        businessVO.setUserId(userId);
        mypageDAO.saveBusinessRegister(businessVO);
    }


    @Override
    public BusinessDTO getBusinessRegister(Long id) {
//        log.info("{}..........99", mypageDAO.findUser(id).getId());
//        return mypageDAO.findBusinessRegister(mypageDAO.findUser(id).getId());

//        String sessionId = (String)session.getAttribute("id");
//        Long userId = Long.parseLong(sessionId);
        log.info("{}..........99", mypageDAO.findUser(id).getId());
        log.info("{}..........98",id);
        return mypageDAO.findBusinessRegister(id);
    }
}

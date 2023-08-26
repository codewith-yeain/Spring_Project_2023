package com.app.icontact.service;

import com.app.icontact.DAO.CommunityDAO;
import com.app.icontact.DTO.CommunityDTO;
import com.app.icontact.domain.CommunityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityDAO communityDAO;
//    private final UserDAO userDAO;
    private final HttpSession session;

    @Override
    public List<CommunityVO> getListComMine(Long id) {
        Long userId = (Long)session.getAttribute("userId");
        return communityDAO.findComMine(userId);
    }


    @Override
    public void writeCom(CommunityVO communityVO) {
        Long userId = (Long)session.getAttribute("userId");
        communityVO.setUserId(userId);
        communityDAO.saveCom(communityVO);
    }

    @Override
    public List<CommunityDTO> getListComAll() {
        return communityDAO.findComAll();
    }
}

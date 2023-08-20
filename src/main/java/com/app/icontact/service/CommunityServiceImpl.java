package com.app.icontact.service;

import com.app.icontact.DAO.CommunityDAO;
import com.app.icontact.domain.CommunityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    private final CommunityDAO communityDAO;

    @Override
    public List<CommunityVO> selectComMine(Long id) {
        return communityDAO.findComMine(id);
    }
}

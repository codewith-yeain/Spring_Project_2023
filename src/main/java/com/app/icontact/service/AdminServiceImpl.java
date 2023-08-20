package com.app.icontact.service;

import com.app.icontact.DAO.AdminDAO;
import com.app.icontact.domain.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;

    //공지사항 글 작성
    @Override
    public void save(NoticeVO noticeVO) { adminDAO.writeNotice(noticeVO); }


}

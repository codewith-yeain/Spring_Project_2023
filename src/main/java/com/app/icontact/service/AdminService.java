package com.app.icontact.service;

import com.app.icontact.domain.NoticeVO;

public interface AdminService {

    //공지사항 글 작성
    public void save(NoticeVO noticeVO);
}

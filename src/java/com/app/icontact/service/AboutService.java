package com.app.icontact.service;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.domain.NoticeVO;

import java.util.List;

public interface AboutService {
    //회사소개 배너
    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory);

    //공지사항 목록
    public List<NoticeVO> noticeList();
}

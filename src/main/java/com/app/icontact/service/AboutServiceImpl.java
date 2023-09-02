package com.app.icontact.service;

import com.app.icontact.DAO.AboutDAO;
import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.domain.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutDAO aboutDAO;

    @Override
    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory) {
        return null;
    }

    //회원목록보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<NoticeVO> noticeList (){
        return aboutDAO.showNoticeList();
    }
}

package com.app.icontact.DAO;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.domain.NoticeVO;
import com.app.icontact.mapper.AboutMapper;
import com.app.icontact.mapper.IdeaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AboutDAO {
    private final AboutMapper aboutMapper;
    private IdeaMapper ideaMapper;

    // 조회수 상위 4개 아이디어 조회
//    public List<IdeaDTO2> findMostReadIdeasByIdeaCategory(Long ideaCategory){
//        return ideaMapper.selectByIdeaCategory(ideaCategory);
//    }

    //공지사항 목록
    public List<NoticeVO> showNoticeList(){ return aboutMapper.selectAllNotice();}

//    //공지사항 상세보기
//    public NoticeVO selectNotice(String noticeTitle);

//    //자주하는 QnA 목록
//    public List<QnA>
}

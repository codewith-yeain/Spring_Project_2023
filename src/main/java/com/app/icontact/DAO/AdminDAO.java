package com.app.icontact.DAO;

import com.app.icontact.domain.NoticeVO;
import com.app.icontact.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    //공지사항 글 작성
    public void writeNotice(NoticeVO noticeVO) {adminMapper.insertNotice(noticeVO);}
}

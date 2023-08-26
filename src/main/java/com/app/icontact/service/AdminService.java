package com.app.icontact.service;

import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import com.app.icontact.domain.NoticeVO;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    //공지사항 글 작성
    public void notice_write(NoticeVO noticeVO);

    // 문의 목록보기
    public List<InquiryDTO> getList(Pagination pagination);

    //문의 보기
    public Optional<InquiryVO> read(Long id);

/*    //문의 답변하기
    public void answer(AnswerVO answerVO);*/
}

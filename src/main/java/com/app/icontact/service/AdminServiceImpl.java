package com.app.icontact.service;

import com.app.icontact.DAO.AdminDAO;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import com.app.icontact.domain.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;

    //공지사항 글 작성
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void notice_write(NoticeVO noticeVO) { adminDAO.writeNotice(noticeVO); }

    //문의목록보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<InquiryDTO> getList(Pagination pagination) {
        final List<InquiryDTO> inquires = adminDAO.showInquiryList(pagination);
        return inquires;
    }

    //문의 보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<InquiryVO> read(Long id) {
        final Optional<InquiryVO> foundInquiry = adminDAO.showInquiry(id);
        return foundInquiry;
    }

   /* //문의 답변하기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void answer(AnswerVO answerVO) { adminDAO.answers(answerVO);}*/
}

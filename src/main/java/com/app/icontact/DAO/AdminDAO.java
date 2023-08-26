package com.app.icontact.DAO;

import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import com.app.icontact.domain.NoticeVO;
import com.app.icontact.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    //공지사항 글 작성
    public void writeNotice(NoticeVO noticeVO) {adminMapper.insertNotice(noticeVO);}


    //문의목록 보기
    public List<InquiryDTO> showInquiryList(Pagination pagination) {
        return adminMapper.selectAllInquiry(pagination);
    }

    //문의 보기
    public Optional<InquiryVO> showInquiry(Long id){
        return adminMapper.selectInquiry(id);
    }

    //문의 답변하기
    public void answers(AnswerVO answerVO){
        adminMapper.insertAnswer(answerVO);
    }
}

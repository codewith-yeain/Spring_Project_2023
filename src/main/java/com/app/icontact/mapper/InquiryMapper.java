package com.app.icontact.mapper;

import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InquiryMapper {
    //  문의 작성
    public void insertInquiry(InquiryVO inquiryVO);

    //문의목록 보기
    public List<InquiryDTO> selectAllInquiry(@Param("pagination") Pagination pagination);

    //문의 보기
    public String selectInquiry(String inquiryId);

    //문의 답변하기
    public void insertAnswer(AnswerVO answerVO);
}

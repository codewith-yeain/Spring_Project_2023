package com.app.icontact.service;

import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;

import java.util.List;
import java.util.Optional;

public interface InquiryService {

    //  문의 작성
    public void inquiry(InquiryVO inquiryVO);


}
package com.app.icontact.service;

import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.InquiryVO;

import java.util.List;

public interface InquiryService {

    //  문의 작성
    public void inquiry(InquiryVO inquiryVO);

    // 문의 목록보기
    public List<InquiryDTO> getList(Pagination pagination);
}

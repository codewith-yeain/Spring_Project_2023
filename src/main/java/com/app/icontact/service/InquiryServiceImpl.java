package com.app.icontact.service;

import com.app.icontact.DAO.InquiryDAO;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.InquiryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {
    private final InquiryDAO inquiryDAO;

    //  문의 작성
    @Override
    public void inquiry(InquiryVO inquiryVO) { inquiryDAO.save(inquiryVO);}

    //문의목록보기
    @Override
    public List<InquiryDTO> getList(Pagination pagination) {return InquiryDAO.showInquiryList(pagination); }
}

package com.app.icontact.service;

import com.app.icontact.DAO.InquiryDAO;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {
    private final InquiryDAO inquiryDAO;

    //  문의 작성
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inquiry(InquiryVO inquiryVO) { inquiryDAO.save(inquiryVO);}


}

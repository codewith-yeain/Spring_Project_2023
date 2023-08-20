package com.app.icontact.service;

import com.app.icontact.DAO.InquiryDAO;
import com.app.icontact.domain.InquiryVO;
import com.app.icontact.domain.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {
    private final InquiryDAO inquiryDAO;

    //  문의 작성
    @Override
    public void inquiry(InquiryVO inquiryVO) { inquiryDAO.save(inquiryVO);}
}

package com.app.icontact.controller;

import com.app.icontact.DAO.InquiryDAO;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import com.app.icontact.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {
    private final InquiryService inquiryService;

    //  문의 작성
    @GetMapping("inquiry")
    public void goToInquiryForm(InquiryVO inquiryVO){;}

    @PostMapping("inquiry")
    public RedirectView inquiry(InquiryVO inquiryVO){
        inquiryService.inquiry(inquiryVO);
        log.info("{}......",inquiryVO.toString());
        return new RedirectView("/icontact/");
    }

}

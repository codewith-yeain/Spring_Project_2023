package com.app.icontact.controller;

import com.app.icontact.domain.InquiryVO;
import com.app.icontact.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {
    private final InquiryService inquiryService;

    //  문의 작성
    @GetMapping("inquiry")
    public void goToinquiryForm(InquiryVO inquiryVO){;}

    @PostMapping("inquiry")
    public RedirectView inquiry(InquiryVO inquiryVO){
        inquiryService.inquiry(inquiryVO);
        log.info("{}......",inquiryVO.toString());
        return new RedirectView("/icontact/icontact");
    }
}

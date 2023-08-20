package com.app.icontact.controller;

import com.app.icontact.domain.NoticeVO;
import com.app.icontact.service.AdminService;
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
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;

    //공지사항 글 작성
    @GetMapping("save")
    public void goToSaveForm(NoticeVO noticeVO){;}

    @PostMapping("save")
    public RedirectView save(NoticeVO noticeVO){
        adminService.save(noticeVO);
        log.info("{}........", noticeVO.toString());
        return new RedirectView("/about/notice");
    }

}

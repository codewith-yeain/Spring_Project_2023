package com.app.icontact.controller;

import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.NoticeVO;
import com.app.icontact.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;
    private final HttpSession session;

   /* //커뮤니티 관리목록
    @GetMapping("communitygetList")*/

    //커뮤니티 글 삭제
    @GetMapping("community")
    public void communitydelete(Long id){
        adminService.communitydelete(id);
        return ;
    }


    //공지사항 글 작성
    @GetMapping("notice_write")
    public void goToSaveForm(NoticeVO noticeVO){;}

    @PostMapping("notice_write")
    public RedirectView notice_write(NoticeVO noticeVO){
        adminService.notice_write(noticeVO);
        log.info("{}........", noticeVO.toString());
        return new RedirectView("/about/notice");
    }


    //문의목록보기
    @GetMapping("inquiry-list")
    public void showList(Pagination pagination, Model model){
        pagination.progress();
        model.addAttribute("inquiries", adminService.getList(pagination));
    }

    //답변하기
    @GetMapping("inquiry-answer")
    public void read(Long id,Model model){
        model.addAttribute("inquiry-answer",adminService.read(id).get());
    }
/*
    @PostMapping("answer")
    public RedirectView answer(AnswerVO answerVO) {
        adminService.answer(answerVO);
        log.info("{}......", answerVO.toString());
        return new RedirectView("/inquiry/inquiry-list");
    }*/

    //회원목록

}

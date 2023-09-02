package com.app.icontact.controller;

import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.NoticeVO;
import com.app.icontact.domain.PaymentVO;
import com.app.icontact.service.AdminService;
import com.app.icontact.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;
    private Long id;
    private Long inquiryVO;

    //공지사항 글 작성
    @GetMapping("notice_write")
    public void goToSaveForm(NoticeVO noticeVO){;}

    @PostMapping("notice_write")
    public RedirectView notice_write(NoticeVO noticeVO){
        adminService.notice_write(noticeVO);
        log.info("{}........", noticeVO.toString());
        return new RedirectView("/about/notice");
    }

    //Q&A 등록


    //결제 목록
    @GetMapping("payment")
    public void goToPayment(Model model) {
        model.addAttribute("posts",adminService.paymentGetList());
    }

    //회원목록보기
    @GetMapping("member")
    public void goToMember(Model model){
        model.addAttribute("lists",adminService.showUserList());
    }

  /*  //커뮤니티 관리목록
   @GetMapping("community")
   public void goToCommuList(Model model){
       model.addAttribute("communitys", adminService.commuList());
   }*/

    //문의목록보기
    @GetMapping("inquiry-list")
    public void showList(Model model){
        model.addAttribute("inquiries",adminService.getList());
    }

    //커뮤니티 글 삭제
    @GetMapping("community")
    public void removeCommu(Long id){
        adminService.communityDelete(id);

    }

  /*  //문의보기
    @GetMapping("inquiry_answer")
    public void choiceInquiry(Model model){
        model.addAttribute("inquiry",adminService.read(inquiryVO));
    }*/

    //답변하기
    @GetMapping("inquiry_answer")
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


    /*@PostMapping("member")
    public ResponseEntity<String> deleteMembers(@RequestBody List<String> memberIds) {
        // memberIds를 기반으로 데이터베이스 업데이트 작업 수행 (회원 삭제 등)

      *//*  // 작업 성공 시
        return ResponseEntity.ok("Members deleted successfully.");

        // 작업 실패 시
        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting members.");*//*
    }



        @PostMapping("/delete-members")
        public ResponseEntity<String> deleteMembers(@RequestBody List<String> memberIds) {
            for (String memberId : memberIds) {
                memberService.deleteMember(memberId); // 회원 정보 삭제
            }

            return ResponseEntity.ok("Members deleted successfully.");
        }
        */


}

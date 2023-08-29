package com.app.icontact.service;

import com.app.icontact.DTO.CommunityDTO;
import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.*;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    //공지사항 글 작성
    public void notice_write(NoticeVO noticeVO);

    //Q&A 글등록


    //결제목록
    public List<PaymentVO> paymentGetList();

    //회원목록보기
    public List<UserVO> showUserList();

    //커뮤니티 관리목록 보기
    public List<CommunityDTO> commuList();

    // 문의 목록보기
    public List<InquiryDTO> getList();



    //문의 보기
    public Optional<InquiryVO> read(Long id);

    //문의 답변하기
    public void inquiryAnswer(AnswerVO answerVO);


    //결제취소
    public void cencelPayment(Long id);

    //회원상태변경
    public void updateUserType (Long id);

    //회원탈퇴 복구
    public void updateUserStatus (Long id);
/*
    //회원탈퇴
    public void deleteUser (Long id);*/


    //커뮤니티 글 삭제
    public void communityDelete(Long id);

    //공지사항 삭제
}

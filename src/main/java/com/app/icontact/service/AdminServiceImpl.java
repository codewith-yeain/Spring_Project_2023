package com.app.icontact.service;

import com.app.icontact.DAO.AdminDAO;
import com.app.icontact.DTO.CommunityDTO;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;
    //공지사항 글 작성
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void notice_write(NoticeVO noticeVO) { adminDAO.writeNotice(noticeVO); }

  /*  //Q&A 글등록
    @Override*/


    //결제목록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PaymentVO> paymentGetList (){
        /* *//*final List<PaymentVO> = *//*adminDAO.showPaymentList(paymentVO);*/
        return adminDAO.showPaymentList();
    }

    //회원목록보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<UserVO> showUserList() {
        return adminDAO.showUserList();
    }

    //커뮤니티 관리목록 보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CommunityDTO> commuList(){
        return adminDAO.showCommunityList();
    }

    //문의목록보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<InquiryDTO> getList() {
        return adminDAO.showInquiryList();
    }


    //문의 보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<InquiryVO> read(Long id) {
        return adminDAO.showInquiry(id);
    }

    //문의 답변하기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inquiryAnswer(AnswerVO answerVO) { adminDAO.answers(answerVO);}


    //결제취소
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cencelPayment(Long id) {adminDAO.cencel(id);}

    //회원상태변경
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserType(Long id){adminDAO.updateUserType(id);}

    //회원탈퇴 복구
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserStatus(Long id) {adminDAO.updateUserStatus(id);}

    //회원탈퇴
    public void deleteMember(Long id) {
        adminDAO.RemoveUser(id);
    }


    //커뮤니티 글 삭제
    public void communityDelete(Long id){ adminDAO.deletecom(id);}

    //공지사항 삭제
}

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

    //커뮤니티 관리목록 보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CommunityDTO> communitygetList (Pagination pagination){
        final List<CommunityDTO> posts = adminDAO.showCommunityList(pagination);
        return posts;
    }

    //커뮤니티 글 삭제
    public void communitydelete(Long id){ adminDAO.delete(id);}

    //공지사항 글 작성
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void notice_write(NoticeVO noticeVO) { adminDAO.writeNotice(noticeVO); }

    //문의목록보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<InquiryDTO> getList(Pagination pagination) {
        final List<InquiryDTO> inquires = adminDAO.showInquiryList(pagination);
        return inquires;
    }

    //문의 보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<InquiryVO> read(Long id) {
        final Optional<InquiryVO> foundInquiry = adminDAO.showInquiry(id);
        return foundInquiry;
    }

   /* //문의 답변하기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void answer(AnswerVO answerVO) { adminDAO.answers(answerVO);}*/

    //결제목록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PaymentVO> paymentGetList (Pagination pagination){
        final List<PaymentVO> tornado = adminDAO.showPaymentList(pagination);
        return tornado;
    }

    //결제취소
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cencelPayment(Long id) {adminDAO.cencel(id);}

    //회원목록보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<UserVO> showUserList(UserVO userVO) {
        final List<UserVO> users = adminDAO.showUserList(userVO);
        return users;
    }

    //회원상태변경
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserType (Long id){adminDAO.updateUserType(id);}

    //회원탈퇴 복구
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserStatus (Long id) {adminDAO.updateUserStatus(id);}
}

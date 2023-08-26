package com.app.icontact.DAO;

import com.app.icontact.DTO.CommunityDTO;
import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.*;
import com.app.icontact.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;
    //커뮤니티 관리목록 보기
    public List<CommunityDTO> showCommunityList (Pagination pagination){
        return adminMapper.selectAllCommunity(pagination);
    }

    //커뮤니티 글 삭제
    public void delete(Long id){adminMapper.delete(id);}

    //공지사항 글 작성
    public void writeNotice(NoticeVO noticeVO) {adminMapper.insertNotice(noticeVO);}


    //문의목록 보기
    public List<InquiryDTO> showInquiryList(Pagination pagination) {
        return adminMapper.selectAllInquiry(pagination);
    }

    //문의 보기
    public Optional<InquiryVO> showInquiry(Long id){
        return adminMapper.selectInquiry(id);
    }

    //문의 답변하기
    public void answers(AnswerVO answerVO){
        adminMapper.insertAnswer(answerVO);
    }

    //결제목록
    public List<PaymentVO> showPaymentList ( Pagination pagination){
        return adminMapper.selectAllPayment(pagination);
    }

    //결제취소
    public void cencel(Long id){adminMapper.updateCancel(id);}

    //회원목록보기
    public List<UserVO> showUserList (UserVO uservo){
        return adminMapper.selelctAllUser(uservo);
    }

    //회원상태변경
    public void updateUserType (Long id) {adminMapper.updateUserType(id);}

    //회원탈퇴 복구
    public void updateUserStatus (Long id) {adminMapper.updateUserStatus(id);}
}

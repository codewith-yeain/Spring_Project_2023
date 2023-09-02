package com.app.icontact.mapper;

import com.app.icontact.DTO.*;
import com.app.icontact.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {
    //공지사항 작성
    public void insertNotice(NoticeVO noticeVO);

    //Q&A 등록
    public void insertQna();


    //결제목록 보기
    public List<PaymentVO> selectAllPayment();

    //회원목록보기
    public List<UserVO> selelctAllUser();

    //커뮤니티 관리목록 보기
    public List<CommunityDTO> selectAllCommunity ();

    //문의목록 보기
    public List<InquiryDTO> selectAllInquiry();



    //문의 보기
    public Optional<InquiryVO> selectInquiry(Long id);

    //문의 답변하기
    public void insertAnswer(AnswerVO answerVO);

    //결제 취소
    public void updateCancel(Long id);

    //회원상태변경
    public void updateUserType(Long id);

    //회원탈퇴 복구
    public void updateUserStatus(Long id);

    //회원탈퇴
    public void deleteUser(Long id);


    //커뮤니티 글 삭제
    public void delete(Long id);

    //공지사항 삭제
    public void deleteNotice(Long id);
}

package com.app.icontact.DAO;

import com.app.icontact.DTO.InquiryDTO;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.AnswerVO;
import com.app.icontact.domain.InquiryVO;
import com.app.icontact.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {
    private final InquiryMapper inquiryMapper;

    //  문의 작성
    public void save(InquiryVO inquiryVO) { inquiryMapper.insertInquiry(inquiryVO);}

/*
    //문의목록 보기
    public List<InquiryDTO> selectAllInquiry(@Param("pagination") Pagination pagination);

    //문의 보기
    public String selectInquiry(String inquiryId);

    //문의 답변하기
    public void insertAnswer(AnswerVO answerVO);


    private final InquiryMapper inquiryMapper;
    //    회원 가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }
    //    회원 가입
    public void insert(MemberVO memberVO);

    //    게시글 목록
    public List<PostDTO> findAll(Pagination pagination, Search search){
        return postMapper.selectAll(pagination, search);
    }
    //    게시글 작성
    public void save(PostVO postVO){
        postMapper.insert(postVO);
    }
    //    게시글 조회
    public Optional<PostDTO> findById(Long id){
        return postMapper.select(id);
    }
    //    게시글 삭제
    public void delete(Long id){
        postMapper.delete(id);
    }
    //    게시글 수정
    public void setPost(PostVO postVO){
        postMapper.update(postVO);
    }
    //    조회수 증가
    public void updateReadCount(Long id){
        postMapper.updateReadCount(id);
    }
    //    전체 게시글 개수
    public int findCountOfPost(Search search){
        return postMapper.selectCountOfPost(search);
    }*/

}

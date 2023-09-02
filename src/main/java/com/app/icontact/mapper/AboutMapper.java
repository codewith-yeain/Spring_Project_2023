package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AboutMapper {
    //공지사항 목록
    public List<NoticeVO> selectAllNotice();

    //공지사항 상세보기
    public NoticeVO selectNotice(String noticeTitle);

    //공지사항 삭제

    //공지사항 삭제
    
    //회사소개 배너(조회수 순)
    public List<IdeaDTO2> selectByIdeaCategory(Long ideaCategory);

}
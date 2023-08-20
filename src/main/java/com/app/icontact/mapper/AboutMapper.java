package com.app.icontact.mapper;

import com.app.icontact.DTO.Pagination;
import com.app.icontact.domain.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AboutMapper {
    //공지사항 목록
    public List<NoticeVO> selectAllNotice (@Param("pagination") Pagination pagination);

    //공지사항 상세보기
    public NoticeVO selectNotice(NoticeVO noticeVO);

    //회사소개 배너(조회수 순)

}

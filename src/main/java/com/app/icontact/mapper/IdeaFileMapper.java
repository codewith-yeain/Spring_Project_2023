package com.app.icontact.mapper;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;
import com.app.icontact.domain.IdeaFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdeaFileMapper {

    //    파일 추가
    public void insert(IdeaFileVO ideaFileVO);

//    //    파일 삭제
//    public void delete(Long id);
//
//    //    게시글의 파일 전체 삭제
//    public void deleteAll(Long postId);
//
    //    파일 조회
    public List<IdeaFileVO> selectAll(Long ideaId);
//
//    //    어제 날짜 파일 조회
//    public List<FileVO> selectYesterday();

}

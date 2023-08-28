package com.app.icontact.mapper;

import com.app.icontact.DTO.BusinessDTO;
import com.app.icontact.domain.BusinessVO;
import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {

//    회원 정보 조회 (회원 정보 가져오기)
    public UserVO selectUser(Long id);

//    내 아아디어들 전부 가져오기
    public List<IdeaVO> selectAllMyIdea(Long id);

//    회원정보 수정 (비번 제외)
    public void updateUser(UserVO userVO);



//    사업자 등록증 등록
    public void insertBusinessRegister(BusinessVO businessVO);

//    사업자 등록증 정보 가져오기 (영업 담당자 정보 포함)
    public BusinessDTO selectBusinessRegister(Long id);


}

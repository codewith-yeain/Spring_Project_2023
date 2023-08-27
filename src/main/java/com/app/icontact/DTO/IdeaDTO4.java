package com.app.icontact.DTO;

import com.app.icontact.domain.IdeaFileVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class IdeaDTO4 {
    private Long id;
    private String ideaTitle;
    private String ideaIntro;
    private String ideaDetail;
    private Long ideaCategory;
    private String ideaRegisterDate;
    private String ideaUpdateDate;
    private String ideaType;
    private Long ideaPrice;
    private Long ideaReadCount;
    private Long ideaMax;
    private Long userId;
    private Long ideaScarpCount;
    private String userNickname; // 작성자 닉네임
    private Long ideaCount; // 현재 몇 명이 이 아이디어에 협의 완료했는지

    private List<IdeaFileVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}

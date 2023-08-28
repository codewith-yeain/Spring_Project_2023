package com.app.icontact.DTO;

import com.app.icontact.domain.IdeaCategoryNames;
import com.app.icontact.domain.IdeaFileVO;
import com.app.icontact.domain.UserVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class IdeaDTO5 {
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

    private UserVO userVO;
    private IdeaCategoryNames ideaCategoryNames; // 해당 아이디어의 상위 및 하위분야 이름

    private Long ideaCount; // 현재 몇 명이 이 아이디어에 협의 완료했는지
    private int totalIdeas; // 해당 유저가 등록한 아이디어의 총 개수

    private List<String> interests = new ArrayList<>();
    private List<IdeaDTO4> otherIdeas = new ArrayList<>();
    private List<IdeaFileVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}

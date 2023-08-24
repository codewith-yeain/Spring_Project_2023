package com.app.icontact.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IdeaDTO3 {
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
    private Long scrapCount;
    private String userNickname;
}

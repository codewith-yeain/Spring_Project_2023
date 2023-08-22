package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IdeaVO {
    private Long id;
    private String ideaTitle;
    private String ideaIntro;
    private String ideaDetail;
    private Long ideaCategory;
    private String ideaRegisterDate;
    private String ideaUpdateDate;
    private String ideaType;
    private Long ideaPrice;
    private Long userId;
}

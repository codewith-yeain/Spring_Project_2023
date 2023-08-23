package com.app.icontact.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CommunityDTO2 {
    private Long id;
    private String communityTitle;
    private String communityContent;
    private String communityRegisterDate;
    private String communityUpdateDate;
    private Long communityReadCount;
    private String sortName;
    private String userNickname;
}

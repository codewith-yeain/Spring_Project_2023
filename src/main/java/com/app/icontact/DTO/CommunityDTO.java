package com.app.icontact.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommunityDTO {
    private Long id;
    private String communityTitle;
    private String communityContent;
    private String communityRegisterDate;
    private String communityUpdateDate;
    private Long communityReadCount; //조회수
    private Long sortId; //창업, 문화, iContact이용후기, 동업제한, 기타
    private Long userId;
    private String userName; //작성자 이름
}

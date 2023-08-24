package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityVO {
    private Long id;
    private String communityTitle;
    private String communityContent;
    private String communityRegisterDate;
    private String communityUpdateDate;
    private Long communityReadCount;
    private Long sortId;
    private Long userId;
}

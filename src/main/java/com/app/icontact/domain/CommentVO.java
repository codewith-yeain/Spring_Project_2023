package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommentVO {
    private Long id;
    private String commentContent;
    private String commentRegisterDate;
    private String commentUpdateDate;
    private Long commentDepth;
    private Long commentGroup;
    private Long memberId;
    private Long communityId;
}

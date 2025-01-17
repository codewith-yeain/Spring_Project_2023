package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IdeaStatusVO {
    private Long id;
    private String ideaStatusType;
    private Long ideaId;
    private Long ideaUserId;
    private Long userId;
}

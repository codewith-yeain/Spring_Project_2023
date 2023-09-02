package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IdeaList {
    private int page;
    private Long ideaCategory; // TBL_IDEA의 상세분류 ID
    private Long ideaPrice; // MAPPER에 넘겨줄 단위
    private Long ideaMax;
    private String order;
}

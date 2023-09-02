package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class InterestVO {
    private Long id;
    private Long subCategoryId;
    private Long userId;
}

package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SubCategoryVO {
    private Long id;
    private String subCategoryName;
    private Long topCategoryId;
}

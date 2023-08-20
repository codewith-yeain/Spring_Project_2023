package com.app.icontact.domain;

import lombok.Data;
import lombok.Lombok;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BusinessVO {
    private Long id;
    private String businessName;
    private String businessNumber;
    private String businessSite;
    private Long businessIndustry;
    private String businessIntro;
    private Long userId;
}

package com.app.icontact.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BusinessDTO {
    private Long id;
    private String businessName;
    private String businessNumber;
    private String businessSite;
    private Long businessIndustry;
    private String businessIntro;
    private Long userId;
//    ==========
    private String userEmail;
    private String userName;
    private String userPhone;

}

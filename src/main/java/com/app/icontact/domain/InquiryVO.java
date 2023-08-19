package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class InquiryVO {
    private Long id;
    private String inquiryType;
    private String inquiryWriterName;
    private String inquiryWriterEmail;
    private String inquiryDate;
    private String inquiryTitle;
    private String inquiryContent;
}

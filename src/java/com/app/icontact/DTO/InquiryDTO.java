package com.app.icontact.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InquiryDTO {
    private Long id;
    private String inquiryWriterName;
    private String inquiryWriterEmail;
    private String inquiryDate;
    private String inquiryTitle;
    private String inquiryContent;
    private Long answerId;
    private String answerDate;
}

package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AnswerVO {
    private Long id;
    private String answerContent;
    private String answerDate;
    private Long userId;
    private Long inquiryId;
}

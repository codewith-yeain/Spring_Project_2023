package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PaymentVO {
    private Long id;
    private String paymentDate;
    private Long paymentAmount;
    private String paymentStatus;
    private String paymentApproveDate;
    private String paymentCancelDate;
    private String paymentSort;
    private Long userId;
    private Long ideaId;
}

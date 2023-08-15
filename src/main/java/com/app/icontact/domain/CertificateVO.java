package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CertificateVO {
    private Long id;
    private String certificatePath;
    private String certificateUuid;
    private String certificateName;
    private String certificateType;
    private Long certificateSize;
    private Long BusinessId;
}

package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProfileVO {
    private Long id;
    private String profilePath;
    private String profileUuid;
    private String profileName;
    private String profileType;
    private Long profileSize;
    private Long memberId;
}

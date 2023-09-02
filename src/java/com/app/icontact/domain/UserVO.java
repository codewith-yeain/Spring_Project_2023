package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userType;
    private String userIntro;
    private String userPhone;
    private String userStatus;
}

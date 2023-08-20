package com.app.icontact.DTO;

import com.app.icontact.domain.ProfileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDTO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userType;
    private String userIntro;
    private String userPhone;
    private String userStatus;
    private ProfileVO profileVO;
}

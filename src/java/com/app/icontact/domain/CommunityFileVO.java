package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityFileVO {
    private Long Id;
    private String communityFilePath;
    private String communityFileUuid;
    private String communityFileName;
    private String communityFileType;
    private Long communityFileSize;
    private Long communityId;

}

package com.app.icontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IdeaFileVO {
    private Long Id;
    private String ideaFilePath;
    private String ideaFileUuid;
    private String ideaFileName;
    private String ideaFileType;
    private Long ideaFileSize;
    private Long ideaId;
}

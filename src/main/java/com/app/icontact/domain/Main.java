package com.app.icontact.domain;

import com.app.icontact.DTO.IdeaDTO4;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class Main {
    private List<Long> interests; // 랜덤 혹은 관심분야

    private List<IdeaDTO4> firstBest; // 조회수 BEST
    private List<IdeaDTO4> secondBest;
    private List<IdeaDTO4> thirdBest;

    private List<IdeaDTO4> firstPremium; // 프리미엄 아이디어 추천
    private List<IdeaDTO4> secondPremium;
    private List<IdeaDTO4> thirdPremium;
}

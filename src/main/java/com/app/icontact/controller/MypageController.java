package com.app.icontact.controller;

import com.app.icontact.domain.BusinessVO;
import com.app.icontact.domain.UserVO;
import com.app.icontact.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {
    private final MypageService mypageService;

    @GetMapping("business-registration")
    // 사업자 등록에 필요한 객체를 인자로 넘겨줄 것. BusinessVO...
    public void register(){;}

    @GetMapping("ict")
    public void goToIctList(){;}

    @GetMapping("mying")
    public void goToIngList(){;}

    @GetMapping("mypage")
    public void goToMypageMain(Long id, Model model){
        model.addAttribute("mypageInfos", mypageService.getUser(id));
    }

    @GetMapping("news")
    public void goToNews(){;}

    @GetMapping("profile-modify")
    // 등록에 필요한 객체를 인자로 넘겨줄것. UserVO, ProfileVO, InterestVO...
    public void goToModify(){;}

    @GetMapping("scrap-list")
    public void goToScrapList(){;}

}

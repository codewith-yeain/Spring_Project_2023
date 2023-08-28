package com.app.icontact.controller;

import com.app.icontact.DTO.BusinessDTO;
import com.app.icontact.domain.BusinessVO;
import com.app.icontact.domain.UserVO;
import com.app.icontact.service.MypageService;
import com.app.icontact.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {
    private final MypageService mypageService;
    private final UserService userService;
    private final HttpSession session;

//    @GetMapping("business-registration")
//    // 사업자 등록에 필요한 객체를 인자로 넘겨줄 것. BusinessVO...
//    public void register(){;}

    @GetMapping("ict")
    public void goToIctList(Long id, Model model){
        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
//        model.addAttribute("id", userId);
        model.addAttribute("mypageInfos", mypageService.getUser(userId));
    }

    @GetMapping("mying")
    public void goToIngList(Long id, Model model){
        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
//        model.addAttribute("id", userId);
        model.addAttribute("mypageInfos", mypageService.getUser(userId));
    }

    @GetMapping("mypage")
    public void goToMypageMain(Long id, Model model){
        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
//        model.addAttribute("id", userId);
        model.addAttribute("mypageInfos", mypageService.getUser(userId));
    }

    @GetMapping("news")
    public void goToNews(){;}

//    @GetMapping("profile-modify")
//    // 등록에 필요한 객체를 인자로 넘겨줄것. UserVO, ProfileVO, InterestVO...
//    public void goToModify(){;}

    @GetMapping("scrap-list")
    public void goToScrapList(){;}

    //    로그인 후 비밀번호 변경
    @GetMapping("find-password")
    public void goToFindPasswordForm(UserVO userVO){;}

//    @GetMapping("profile-modify")
//    public void goToChangeUserInfoForm(UserVO userVO){
//        log.info("{}.....2222.....{}", session.getAttribute("id"), userVO);
//
//    }

    @GetMapping("profile-modify")
    public void goToChangeUserInfoForm(Long id, Model model){
//        log.info("{}.....2222.....{}", session.getAttribute("id"), userVO);
        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
        model.addAttribute(mypageService.getUser(userId));

        log.info(".........................{}", userId);

    }

    @PostMapping("profile-modify")
    public RedirectView changedUserInfo(UserVO userVO, RedirectAttributes redirectAttributes) {

        log.info("{}.....1111.....{}", session.getAttribute("id"), userVO);

        mypageService.modifyUserInfo(userVO);
        redirectAttributes.addAttribute("id", userVO.getId());
        return new RedirectView("/mypage/mypage");
    }


    @GetMapping("business-registration")
    // 사업자 등록에 필요한 객체를 인자로 넘겨줄 것. BusinessVO...
    public void register(BusinessDTO businessDTO, Model model){
        String sessionId = (String)session.getAttribute("id");
        Long userId = Long.parseLong(sessionId);
        businessDTO.setUserId(userId);

        log.info("{}.....9999.....{}", session.getAttribute("id"), businessDTO);
        model.addAttribute(mypageService.getBusinessRegister(userId));
    }

    @PostMapping("business-registration")
    public RedirectView writeRegister(){
        return new RedirectView();
    }




}

package com.app.icontact.controller;

import com.app.icontact.domain.CommunityVO;
import com.app.icontact.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {
    private final CommunityService communityService;

    @GetMapping("listAll")
    public void goToComListAll(){;}

    @GetMapping("listMine")
    public void goToComListMine(){;}
//
    @GetMapping("write")
    public void goToComWrite(){;}
//
    @PostMapping("wirte")
    public RedirectView writeCom(CommunityVO communityVO, RedirectAttributes redirectAttributes){
        communityService.writeCom(communityVO);
        redirectAttributes.addAttribute("id", communityVO.getId());
        return new RedirectView("/community/listAll");
    }
//
//    @GetMapping(value = {"read", "modify"})
//
//    @PostMapping("modify")
//
//    @GetMapping("remove")




}

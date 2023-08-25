package com.app.icontact.controller;

import com.app.icontact.DTO.IdeaDTO4;
import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import com.app.icontact.exception.LoginFailedException;
import com.app.icontact.service.IdeaService;
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
@RequestMapping("/idea/*")
public class IdeaController {
    private final IdeaService ideaService;
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("detail")
    public void detail(Long id){;}

    @GetMapping("ideaBank")
    public void list(){;}

    @GetMapping("update")
    public void goToUpdateIdeaForm(){;}

    @PostMapping("update")
    public RedirectView update(IdeaVO ideaVO, RedirectAttributes redirectAttributes){
        return new RedirectView("/idea/detail");
    }

    @GetMapping("write")
    public void goToWriteIdeaForm(IdeaDTO4 ideaDTO4, Model model){
        String sessionId = (String)session.getAttribute("id");
        Long id = Long.parseLong(sessionId);
        model.addAttribute("id", id);

        model.addAttribute("userNickname", userService.getUser(id).get().getUserNickname());
    }

    @PostMapping("write")
    public RedirectView write(IdeaDTO4 ideaDTO4){
        log.info(ideaDTO4.toString());

        String sessionId = (String)session.getAttribute("id");
        Long id = Long.parseLong(sessionId);

        ideaDTO4.setUserId(id);
        ideaService.write(ideaDTO4);
        return new RedirectView("/idea/ideaBank");
    }


}

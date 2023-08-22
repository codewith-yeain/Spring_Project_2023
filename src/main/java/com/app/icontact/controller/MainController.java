package com.app.icontact.controller;

import com.app.icontact.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/icontact/*")
public class MainController {
    private final MainService mainService;

    @GetMapping("/")
    public String goToMain(Model model){
//        model.addAttribute("first", mainService.getFirstList) -> 배너에 필요한 리스트

        return "/icontact/icontact";
    }

}

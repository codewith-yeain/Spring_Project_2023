package com.app.icontact.controller;

import com.app.icontact.DAO.SubCategoryDAO;
import com.app.icontact.service.IdeaService;
import com.app.icontact.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Random;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/icontact/*")
public class MainController {
    private final MainService mainService;
    private final IdeaService ideaService;
    private final SubCategoryDAO subCategoryDAO;

    @GetMapping("/")
    public String goToMain(Model model){
        Random rand = new Random();
        Long ideaCategory1 = (long)(rand.nextInt(56) + 1);
        Long ideaCategory2 = (long)(rand.nextInt(56) + 1);
        Long ideaCategory3 = (long)(rand.nextInt(56) + 1);

        /*카테고리 이름*/
        model.addAttribute("firstCategory", subCategoryDAO.findName(1L));
        model.addAttribute("secondCategory", subCategoryDAO.findName(ideaCategory2));
        model.addAttribute("thirdCategory", subCategoryDAO.findName(ideaCategory3));

        /*조회수순*/
        model.addAttribute("first", ideaService.getMostReadIdeas(1L));
        model.addAttribute("second", ideaService.getMostReadIdeas(ideaCategory2));
        model.addAttribute("third", ideaService.getMostReadIdeas(ideaCategory3));

        /*관심분야 기준*/
        model.addAttribute("firstInterest", ideaService.getPremiumIdeas(1L));
        model.addAttribute("secondInterest", ideaService.getPremiumIdeas(ideaCategory2));
        model.addAttribute("thirdInterest", ideaService.getPremiumIdeas(ideaCategory3));

        return "/icontact/icontact";
    }

}

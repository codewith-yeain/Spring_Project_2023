package com.app.icontact.controller;

import com.app.icontact.DAO.SubCategoryDAO;
import com.app.icontact.service.AboutService;
import com.app.icontact.service.IdeaService;
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
@RequestMapping("/about/*")
public class AboutController {
    private final AboutService aboutService;
    private final SubCategoryDAO subCategoryDAO;
    private final IdeaService ideaService;
// introduce.html, notice.html, qna.html

    @GetMapping("introduce")
    public String goToIntroduce(Model model){
        Random rand = new Random();
        Long ideaCategory1 = (long)(rand.nextInt(56) + 1);
        Long ideaCategory2 = (long)(rand.nextInt(56) + 1);
        Long ideaCategory3 = (long)(rand.nextInt(56) + 1);

        /*조회수순*/
        model.addAttribute("first", ideaService.getMostReadIdeas(1L));
        model.addAttribute("second", ideaService.getMostReadIdeas(ideaCategory2));
        model.addAttribute("third", ideaService.getMostReadIdeas(ideaCategory3));

        /*관심분야 기준*/
        model.addAttribute("firstInterest", ideaService.getPremiumIdeas(1L));
        model.addAttribute("secondInterest", ideaService.getPremiumIdeas(ideaCategory2));
        model.addAttribute("thirdInterest", ideaService.getPremiumIdeas(ideaCategory3));

        /*아이디어 스크랩수 상위 3개*/
        model.addAttribute("scrapTopIdeas", ideaService.getTopScrapIdeas());

        return "/about/introduce";
    }

    @GetMapping("notice")
    public void goToNotice(){;}

    @GetMapping("qna")
    public void goToQna(){;}

}

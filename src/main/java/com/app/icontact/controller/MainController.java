package com.app.icontact.controller;

import com.app.icontact.DAO.CommunityDAO;
import com.app.icontact.DAO.SubCategoryDAO;
import com.app.icontact.DAO.UserDAO;
import com.app.icontact.DTO.CommunityDTO2;
import com.app.icontact.service.IdeaService;
import com.app.icontact.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/icontact/*")
public class MainController {
    private final MainService mainService;
    private final IdeaService ideaService;
    private final SubCategoryDAO subCategoryDAO;
    private final CommunityDAO communityDAO;
    private final UserDAO userDAO;

    @GetMapping("/")
    public String goToMain(Model model, HttpSession session){
        String sessionId = (String)session.getAttribute("id");
        Long id = null;
        if (sessionId != null) {
            id = Long.parseLong(sessionId);
        }

        Long ideaCategory1 = null;
        Long ideaCategory2 = null;
        Long ideaCategory3 = null;

        Random rand = new Random();
        ideaCategory1 = (long)(rand.nextInt(56) + 1);
        ideaCategory2 = (long)(rand.nextInt(56) + 1);
        ideaCategory3 = (long)(rand.nextInt(56) + 1);

//        if (id == null){
//
//        } else {
//            List<Long> interests = userDAO.findInterestsByUserId(id);
//            if(interests != null && !interests.isEmpty()) {
//                if(interests.size() > 0) ideaCategory1 = interests.get(0);
//                if(interests.size() > 1) ideaCategory2 = interests.get(1);
//                if(interests.size() > 2) ideaCategory3 = interests.get(2);
//            }
//        }

        /*카테고리 이름*/
        model.addAttribute("firstCategory", subCategoryDAO.findName(1L));
        model.addAttribute("secondCategory", subCategoryDAO.findName(2L));
        model.addAttribute("thirdCategory", subCategoryDAO.findName(30L));

        /*조회수순*/
        model.addAttribute("first", ideaService.getMostReadIdeas(1L));
        model.addAttribute("second", ideaService.getMostReadIdeas(2L));
        model.addAttribute("third", ideaService.getMostReadIdeas(30L));

        /*관심분야 기준*/
        model.addAttribute("firstInterest", ideaService.getPremiumIdeas(1L));
        model.addAttribute("secondInterest", ideaService.getPremiumIdeas(2L));
        model.addAttribute("thirdInterest", ideaService.getPremiumIdeas(30L));

        /*게시글 조회수 상위 3개*/
        model.addAttribute("communityList", communityDAO.findCommunityByReadCount());

        /*아이디어 스크랩수 상위 3개*/
        model.addAttribute("scrapTopIdeas", ideaService.getTopScrapIdeas());
        System.out.println(ideaService.getTopScrapIdeas().toString());

        return "/icontact/icontact";
    }

}

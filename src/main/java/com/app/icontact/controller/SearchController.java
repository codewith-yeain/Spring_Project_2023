package com.app.icontact.controller;

import com.app.icontact.service.IdeaService;
import com.app.icontact.service.SearchService;
import com.app.icontact.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/search/*")
public class SearchController {
    private final SearchService searchService;
    private final IdeaService ideaService;
    private final UserService userService;

    @GetMapping("search-all")
    public void goToSearchAll(@RequestParam String keyword, Model model){
        model.addAttribute("ideas", ideaService.findIdea(keyword));
        model.addAttribute("users", userService.findUser(keyword));
        model.addAttribute("keyword", keyword);
    }

    @GetMapping("search-idea")
    public void goToSearchIdea(@RequestParam String keyword, Model model){
        model.addAttribute("ideas", ideaService.findIdea(keyword));
        model.addAttribute("keyword", keyword);
    }

    @GetMapping("search-user")
    public void goToSearchUser(@RequestParam(required=false, defaultValue="") String keyword, Model model){
        model.addAttribute("users", userService.findUser(keyword));
        model.addAttribute("keyword", keyword);
    }

//    @PostMapping("search-all")
//    @ResponseBody
//    public void goToSearchAllList(@RequestBody(required=false, defaultValue="") String keyword){
//        ;
//    }
//
//    @PostMapping("search-idea")
//    @ResponseBody
//    public void goToSearchIdeaList(@RequestBody(required=false, defaultValue="") String keyword){;}
//
//    @PostMapping("search-user")
//    @ResponseBody
//    public void goToSearchUserList(@RequestBody(required=false, defaultValue="") String keyword){;}

}

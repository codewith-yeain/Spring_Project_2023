package com.app.icontact.controller;

import com.app.icontact.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/search/*")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("search-all")
    public void goToSearchAllList(){;}

    @GetMapping("search-idea")
    public void goToSearchIdeaList(){;}

    @GetMapping("search-user")
    public void goToSearchUserList(){;}

}

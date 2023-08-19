package com.app.icontact.controller;

import com.app.icontact.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {
    private final CommunityService communityService;

//    @GetMapping("list")
//
//    @GetMapping("wirte")
//
//    @PostMapping("wirte")
//
//    @GetMapping(value = {"read", "modify"})
//
//    @PostMapping("modify")
//
//    @GetMapping("remove")




}

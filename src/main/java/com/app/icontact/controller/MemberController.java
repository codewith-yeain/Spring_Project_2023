package com.app.icontact.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    @GetMapping("join")
    public void join(){
        log.info("join.................");
    }

    @GetMapping("login")
    public void login(){
        log.info("login.................");
    }

    @GetMapping("find-password")
    public void findPassword(){
        log.info("find-password.................");
    }


}

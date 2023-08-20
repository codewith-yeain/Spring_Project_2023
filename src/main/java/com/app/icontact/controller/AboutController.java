package com.app.icontact.controller;

import com.app.icontact.service.AboutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/about/*")
public class AboutController {
    private final AboutService aboutService;
// introduce.html, notice.html, qna.html

    @GetMapping("introduce")
    public void goToIntroduce(){;}

    @GetMapping("notice")
    public void goToNotice(){;}

    @GetMapping("qna")
    public void goToQna(){;}

}

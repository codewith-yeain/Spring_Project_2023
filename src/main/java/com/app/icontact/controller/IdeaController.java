package com.app.icontact.controller;

import com.app.icontact.service.IdeaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/idea/*")
public class IdeaController {
    private final IdeaService ideaService;

}

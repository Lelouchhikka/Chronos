package com.itstep.trelloanalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/")
    public String index() {
        return "mainPage";
    }
}

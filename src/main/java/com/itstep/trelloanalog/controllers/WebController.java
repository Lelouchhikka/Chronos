package com.itstep.trelloanalog.controllers;

import com.itstep.trelloanalog.entities.DbUser;
import com.itstep.trelloanalog.entities.Project;
import com.itstep.trelloanalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class WebController {

   private final UserService userService;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/")
    public String index(Model mav) {
        mav.addAttribute("users", userService.allUsers());
        mav.addAttribute("user",new DbUser());
        mav.addAttribute("project",new Project());
        return "mainPage";
    }
}

package com.LearningSpring.SchoolProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /* We can have multiple mappings in one @RequestMapping */
    @RequestMapping(value={"home","","/"})
    public String displayHomePage() {
        return "home.html";
    }

}

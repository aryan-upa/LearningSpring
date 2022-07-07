package com.LearningSpring.SchoolProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /* We can have multiple mappings in one @RequestMapping
    *  Model is an interface which acts as a container to carry data from backend to frontend.
    * */
    @RequestMapping(value={"/home", "", "/"})
    public String displayHomePage(Model model) {
        model.addAttribute("username", "Aryan Upadhyay");
        return "home.html";
    }

}

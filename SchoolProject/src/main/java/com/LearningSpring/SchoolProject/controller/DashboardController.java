package com.LearningSpring.SchoolProject.controller;

import com.LearningSpring.SchoolProject.model.Person;
import com.LearningSpring.SchoolProject.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    final PersonRepository personRepository;

    public DashboardController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        session.setAttribute("loggedInPerson", person);
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        return "dashboard.html";
    }

}

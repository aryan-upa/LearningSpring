package com.LearningSpring.SchoolProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class ContactController {

    private final Logger log = Logger.getLogger(ContactController.class.getName());

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    /*
        This method is to take input from the user using the form. The forms are submitted using POST method, as data is
         being sent from the user and has to be saved in the system.

        All the field in the form has to be accessed here using the Parameter names. Parameter name here should be same
        as field name which is given in the form.
        saveMessage(@RequestParam String name)

        To change the parameter name we have to externally define what is the name of field defined in the form.
        saveMessage(@RequestParam(name="name") String anyOtherName)
     */
    @PostMapping("/saveMsg") // OR @RequestMapping("/saveMsg", Method = POST)
    public ModelAndView saveMessage(
            @RequestParam String name,
            @RequestParam String mobileNum,
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String message) {
        log.info("Name : "+ name);
        log.info("mobile number : " + mobileNum);
        log.info("email : " + email);
        log.info("subject : " + subject);
        log.info("message : " + message);
        return new ModelAndView("redirect:/contact");
    }

}

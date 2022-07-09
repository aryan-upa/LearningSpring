package com.LearningSpring.SchoolProject.controller;

import com.LearningSpring.SchoolProject.model.Contact;
import com.LearningSpring.SchoolProject.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ContactController {

    private final Logger log = Logger.getLogger(ContactController.class.getName());

    private final ContactService contactService;

    @Autowired
    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        // Added the contact POJO object to the frontend.
        model.addAttribute("contact", new Contact());
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

        Or we can create a POJO class to reflect all the fields in the Form and use that POJO class as reference to what
         we have to input.

        Usually in Production Grade applications we do not do much with data except preliminary validations inside the
        controller class. Then we send our data to the Service layer for further processing & use.
     */
    @PostMapping("/saveMsg") // OR @RequestMapping("/saveMsg", Method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        // Errors parameter is to take errors from the frontend and display them in the backend.
        if(errors.hasErrors()) {
            log.log(Level.SEVERE, "Form Validation failed due to " + errors);
            // returning with "/contact" reloads the page but keeps the data intact.
            return "/contact";
        }
        contactService.saveMessageDetails(contact);
        // returning with "redirect:/contact" not only reloads the page but also removes the previous data in the page.
        return "redirect:/contact";
    }

}

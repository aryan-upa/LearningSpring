package com.LearningSpring.SchoolProject.controller;

import com.LearningSpring.SchoolProject.model.Address;
import com.LearningSpring.SchoolProject.model.Person;
import com.LearningSpring.SchoolProject.model.Profile;
import com.LearningSpring.SchoolProject.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ProfileController {

    private final PersonRepository personRepository;

    @Autowired
    public ProfileController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("profile.html");

        Person person = (Person) httpSession.getAttribute("loggedInPerson");
        Profile profile = new Profile();

        modelAndView.addObject("profile", profile);

        profile.setName(person.getName());
        profile.setPhoneNumber(person.getPhoneNumber());
        profile.setEmail(person.getEmail());

        if (person.getAddress() == null || person.getAddress().getAddressId() < 1) // Verifying that address field does exist or not.
            return modelAndView;

        Address address = person.getAddress();

        profile.setAddress1(address.getAddress1());
        profile.setAddress2(address.getAddress2());
        profile.setCity(address.getCity());
        profile.setState(address.getState());
        profile.setZipCode(address.getZipCode());

        return modelAndView;
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile,
                                HttpSession httpSession,
                                Errors errors) {

        if(errors.hasErrors())
            return "profile.html";

        Person person = (Person) httpSession.getAttribute("loggedInPerson");

        // Personal data.
        person.setName(profile.getName());
        person.setPhoneNumber(profile.getPhoneNumber());
        person.setEmail(profile.getEmail());

        // Address data.
        if (person.getAddress() == null || !(person.getAddress().getAddressId() > 0))
            person.setAddress(new Address());

        Address address = person.getAddress();
        address.setAddress1(profile.getAddress1());
        address.setAddress2(profile.getAddress2());
        address.setState(profile.getState());
        address.setCity(profile.getCity());
        address.setZipCode(profile.getZipCode());

        personRepository.save(person);
        httpSession.setAttribute("loggedInPerson", person);

        return "redirect:/dashboard";
    }

}

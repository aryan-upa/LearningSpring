package com.LearningSpring.SchoolProject.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebConfig implements WebMvcConfigurer {

    /*
        We use WebConfig class (name not compulsory) when we want to define a route to an always static page address.
        In our case, courses page is static for all viewers, therefore creating a controller and writing a method is not
         worth it.
        In this same method we can add many other static links.
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/courses").setViewName("courses");
    }
}

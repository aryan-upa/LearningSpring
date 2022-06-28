package com.example.beans;

import org.springframework.stereotype.Component;

/*
    @Component : This annotation is crucial to working of Spring. It tells the framework that a Bean of this class
                 should be created and make present in the Spring IOC Container. The other method of creating a bean is
                 very verbose as we have to define method in the ProjectConfig class and creating those methods for 100s
                  of classes is very tedious and error-prone.
 */
@Component
public class Driver {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printAbout() {
        System.out.println("I am a Driver, I drive vehicles.");
    }
}

package com.assignment.main;

import com.assignment.beans.person.Person;
import com.assignment.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        person.setName("Aryan Upadhyay");
        person.drive();

        System.out.println(person);
    }
}

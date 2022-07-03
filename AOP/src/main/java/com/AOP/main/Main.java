package com.AOP.main;

import com.AOP.beans.person.Person;
import com.AOP.config.ProjectConfig;
import com.AOP.generic.classes.Song;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        person.setName("Aryan Upadhyay");
        boolean isVehicleStarted = true;
        Song song = new Song("Ontario", "Novo Amor");
        person.getVehicle().getVehicleServices().play(isVehicleStarted, song);
        person.getVehicle().getVehicleServices().drive(isVehicleStarted);

        System.out.println(person);
    }
}

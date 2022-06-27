package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
    @Configuration This annotation is part of the spring core framework. This annotation indicates that the class has @Bean
                    definition methods. So Spring can process the class and generate Spring Beans to be used in the
                    application.
 */
@Configuration
public class ProjectConfig {

    /**
        @Bean annotation which lets Spring know that it needs to call this method when it initializes its context and
              adds the returned value to the context.
     */
    @Bean
    Vehicle vehicle() {
        var vehicle  = new Vehicle();
        vehicle.setName("BMW Urus");
        return vehicle;
    }

    @Bean
    Vehicle anotherVehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Maruti 800");
        return vehicle;
    }

    /**
        hello method is used to return the "hello world" string to the caller.
        The method names usually follow verbs notation. But, for methods which we will use to create beans, can use
        nouns as names. This will be a good practice as the method names will become bean names as well in the context.
     */
    @Bean
    String hello() {
        return "Hello World";
    }


    @Bean
    Integer number() {
        return 16;
    }
}

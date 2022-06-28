package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Bean(value="BMW_Car")
    Vehicle vehicle() {
        var vehicle  = new Vehicle();
        vehicle.setName("BMW Urus");
        return vehicle;
    }

    @Bean(name="Maruti_Car")
    Vehicle anotherVehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Maruti 800");
        return vehicle;
    }

    /**
        When we have multiple beans of the same kind inside the Spring context, you can make one of them primary by
        using <b>@Primary</b> annotation. Primary bean is the one which Spring will choose if it has multiple options, and you
        don't specify a name. In other words, it's the default bean that Spring Context will consider in case of
        confusion due to multiple beans present of same type.
     */
    @Bean("Lamborghini_Car")
    @Primary
    Vehicle anotherAnotherVehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Lamborghini");
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

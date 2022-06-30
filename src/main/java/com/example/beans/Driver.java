package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
    @Component : This annotation is crucial to working of Spring. It tells the framework that a Bean of this class
                 should be created and make present in the Spring IOC Container. The other method of creating a bean is
                 very verbose as we have to define method in the ProjectConfig class and creating those methods for 100s
                  of classes is very tedious and error-prone.
 */
@Component
public class Driver {
    private String name;

    /*
        The @Autowired annotation marks on a field, constructor, Setter method is used to auto-wire the beans that is
        'injecting beans' (Objects) at runtime by Spring Dependency Injection mechanism.

        But, the issue is that when we autowire a field, we can not make it final as it would not have been initialized
        until the run-time.

        We can do this, because our Vehicle beans are already defined with @Bean annotation in the ProjectConfig class.

        If in any-case we have no issue in bean not forming until the time of creation of Driver Bean, ie the presence
        of Vehicle bean is not mandatory then we can annotate the field with @Autowired but with required flag set to
        false.

        We can also use the @Autowired annotation on the setter method of the field, these are just two different
        methods of using the @Autowired annotation but has no such difference.

        But, both of these methods are not Production Grade.
     */
    @Autowired()
    private final Vehicle vehicle;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printAbout() {
        System.out.println("I am a Driver, I drive " + vehicle.getName() +".");
    }

    /*
        The PreConstruct Annotation is used to do some work on a Bean after its creation. Since these were a part of
        Java EE and Java EE was deprecated in JDK9 and removed in JDK11 thus, we have to add a dependency to use them.
     */
    @PostConstruct
    public void initialize() {
        setName("Undefined");
    }

    /*
        The @PreDestroy Annotation is used to do some work before the bean is destroyed. A Bean is destroyed when it's
        context is closed.
     */
    @PreDestroy
    public void doEndOfSession() {
        System.out.println("Driver is going home now.");
    }

    Driver(Vehicle vehicle) {
        /*
            In our case there is no 'NoUniqueBeanDefinitionException', as although there are multiple beans of vehicle
            type, we have a @Primary bean ("Lamborghini"). Thus Spring wires the Primary bean to this Object.
         */
        this.vehicle = vehicle;
    }
}

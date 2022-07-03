package com.AOP.generic.classes;

public record Song(String name, String artist) {

    /*
        Aspect Oriented Programming :
            The Aspect Oriented Programming (AOP) is another approach of thinking about the Program structure. The key
            unit of modularity in OOP is class, whereas in AOP the unit of modularity is the aspect.

        What is Aspect :
            The literal meaning : A particular part or feature of something.
            An aspect is simply a piece of code that is executed when we call specific methods inside our application.
            An aspect is a common feature that's typically scattered across methods, classes, object hierarchies, or
            even entire object models.

        In AOP, aspects enable modularization of concerns such as transaction management, logging or security that cut
        across multiple types and objects (often termed crosscutting concerns).

        AOP provides the way to dynamically add the crosscutting concerns before, after or around the actual logic
        using simple pluggable configurations.

        AOP helps in separating and maintaining many non-business logics related to logging, security etc. In this way
        we can add additional behaviour to existing code without changing the code itself.

        AOP Jargon ---

        When we define an Aspect or doing configurations, we need to follow WWW (3 Ws) :
            WHAT -> Aspect : What we need to do, what logic we want ot execute. Any non-business logic goes in here.
            WHEN -> Advice : When do we need to perform this logic. Before or after is decided here.
            WHICH -> Pointcut : Which method we want to intercept to perform the What and When.

        Others :
            Join Point : which defines the event that triggers the execution of an aspect. Inside spring, this event is
                always a method call.
            Target Object : is the bean that declares the method/pointcut which is intercepted by an Aspect.

        Typical Scenario of AOP Implementation :

                             Aspect                  Advice      JoinPoint            Pointcut
                           ____|_____                __|___      ____|____           _____|_____
            Developer want some logic to be executed before each execution of method playMusic() present inside bean
            VehicleServices
            """""""|""""""
             Target Object

        Weaving Inside AOP :
            When we are implementing AOP inside our App using Spring Framework, it will intercept each method call and
            apply the logic defined in the Aspect.

            Spring does this with the help of proxy object, So we try to invoke a method inside a bean, Spring instead
            of directly giving reference of the bean instead it will give a proxy object that will manage each call to a
             method and apply the aspect logic. This process is called weaving.


             Without AOP, method is directly called and no interception by     |=====================|
                                     Spring                                    |                     |
            ------------------------------------------------------------------>|   VehicleServices   |
                                                                               |       Bean          |
                                                                               |                     |
                                                                               | void playMusic() {  |
                                |-----------------------|                      |   // Business       |
                Intercept       |    Proxy Object of    |     Delegation       |   // logic          |
            ------------------->|    VehicleServices    |--------------------->| }                   |
                                |         Bean          |                      |                     |
                                |-----------------------|                      |                     |
                                                                               |=====================|

        Types of Advice in AOP :
            @Before : It makes sure that the aspect logic runs before the matched method execution.

            @AfterReturning : This makes sure that the advice runs when a matched method execution completes normally.

            @AfterThrowing : This advice runs the aspect logic after and if the matched method execution exits by
                    throwing an Exception.

            @After : This makes the advice runs no matter how a matched method execution exits.

            @Around : This advice makes the aspect runs "around" a matched method execution. It has the opportunity to
                    do work both before and after the method runs and to determine, how, and even if the method actually
                     gets to run at all.


     */

}

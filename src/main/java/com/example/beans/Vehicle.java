package com.example.beans;

public class Vehicle {

    /*
        Eager and Lazy Instantiation :
            Eager Instantiation :
                The creation of bean is the responsibility of the Spring IOC Container, by default the Spring will
                create all the beans inside an application during the startup of the program. This is called Eager
                Instantiation.
            Lazy Instantiation :
                The creation of bean in this case as well is the responsibility of the Spring IOC Container, but in this
                 case the Bean creation does not take place at the startup of the program, in fact it only even occurs
                when that bean is called for the first time. This is called Lazy Instantiation. To do the lazy
                instantiation, just add @Lazy annotation. It is used with services which are rarely used, eg: Account
                Deletion Bean.

            Pros & Cons :
                Though, Lazy instantiation takes the load off of the startup and makes the startup faster, as lesser the
                 number of beans, faster the startup. But, this also raises an issue, in case our Lazy Bean has some
                error in it. So that error won't be known until the bean is actually created. This way there is no way
                to check whether the bean is working fine or not.

                In Eager instantiation, the bean creation takes place at startup making it a bit longer to start. But,
                if by-chance there is any error in any bean, then the application won't start. This way we know before
                deploying whether there is any error in the bean or not.
     */

    private String name;
    private Registration registration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Registration getRegistration() {
        return registration;
    }
}

package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
    @Component : This annotation is crucial to working of Spring. It tells the framework that a Bean of this class
                 should be created and make present in the Spring IOC Container. The other method of creating a bean is
                 very verbose as we have to define method in the ProjectConfig class and creating those methods for 100s
                  of classes is very tedious and error-prone.
    @Scope     : This annotation is used to define the scope of the bean inside the Spring IOC Container. This comes
                 into picture in the production scenarios when there are multiple threads running inside the system and
                 multiple Users using the System concurrently, then how the Spring will understand the dependencies. And
                  how these dependencies will be managed. Bean scope determines how the spring IOC Container will create
                  a new bean when asked, will it give the reference to the old bean or a new bean will be created.

                 There are total 5 Types of scopes:
                    1. Singleton        [ Default Scope ]
                    2. Prototype
                    3. Request          --|
                    4. Session          --+--> Web-Based
                    5. Application      --|

                 1. Singleton Scope:
                    When we have a bean inside our application, and we try to refer it using any method. We always get
                    the same instance of the bean. Similar to singleton design pattern. In singleton bean scope, we can
                    have multiple beans of same data-type only when they arise from different beans. I.e. we can have 1
                    instance per unique bean in our system.

                    @Scope(BeanDefinition.SCOPE_SINGLETON) -> To create a bean's scope singleton.

                    Issue with incorrect usage of Singleton Scope : Race Condition :
                        A race condition occurs when two threads access a shared variable at the same time. The first
                        thread reads teh variable, and the second thread reads the same value from the variable. Then
                        the first thread and second thread perform their operations on the value, and they race to see
                        which thread can write the value last to the shared variable. The value of the thread that
                        writes its value last is preserved, because the thread is writing over the value that the
                        previous thread wrote.

                        If we have a single object instance in our application and multiple threads are trying to access
                         it, then there's good chance that it may lead to race condition. To avoid this, we make sure
                        that whatever bean is used in a singleton scope, there must be no updates or deletion in data
                        in that bean. Because if it has, then we may have to apply Locking and Synchronization in
                        updates and deletion.

                    Where to use Singleton beans :
                        Since the same instance of bean will be used by multiple threads inside your application, it is
                        very important that these beans are immutable.

                        This cope is more suitable for beans which handles service layer, repository layer or business
                        logic. These beans should be made of classes which have only methods inside them but not Data.
                        Because if at any moment two threads concurrently try to access the bean, it will result in race
                         condition.

                        There are always ways to avoid race conditions due to mutable singleton beans with the help of
                        synchronization, But it is not recommended as it brings a lot of complexity and performance
                        issues.

 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
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

    /*
        Defining @Autowired annotation on top of a constructor does have some benefits over the other 2 approaches as
        with use of this we can create final fields in our class and set them in our constructor.

        After Spring 4.3 :
            When we have only one constructor we may or may not have the @Autowired configured because it will work
            internally, but when we have multiple constructors in our Java class then we have to have @Autowired in our
            class.


        How does Autowiring takes place if there are more than one bean, or beans are identified by their names, or how
        does the programmer will set the autowiring configuration to use a particular type of bean.

        By default, Spring tries to autowire with class type. But this approach will fail if the same class type has
        multiple beans.

        In example in our system there are three beans of Vehicle class

        @Bean("vehicle1")
        Vehicle vehicle1(){...}

        @Bean("vehicle2")
        Vehicle vehicle2(){...}

        @Primary
        @Bean("vehicle3")
        Vehicle vehicle3(){...}

        Method1 : (Using parameter name / field name)
            In this method Spring will try to auto-wire based on the parameter name/field name that we use while
            configuring autowiring annotation.

            Example :
                This Constructor will autowire to vehicle1 bean in the system.

                @Autowired
                public Person(Vehicle vehicle1) {
                    this.vehicle = vehicle1
                }

        Method2 : (@Primary Bean)
            In this method if the bean is not found from method1, then the constructor will wire the object with the
            bean which has @Primary annotation, or the primary bean.

            Example :
                This Constructor will autowire to vehicle3 bean in the system.

                @Autowired
                public Person(Vehicle vehicle) {
                    this.vehicle = vehicle;
                }

        Method3 : (@Qualifier Bean)
            In this step the Spring will look for a bean which matches with the name given in @Qualifier annotation in
            the constructor. The Spring will look for an exact match if nothing works from method1 & method2.

            Example :
                This Constructor will autowire to vehicle1 bean in the system. [Consider no @Primary bean]

                @Autowired
                public Person(@Qualifier("vehicle1") Vehicle vehicle) {
                    this.vehicle = vehicle;
                }

     */
    @Autowired
    Driver(@Qualifier("BMW_Car") Vehicle vehicle) {
        /*
            In our case there is no 'NoUniqueBeanDefinitionException', as although there are multiple beans of vehicle
            type, we have a @Primary bean ("Lamborghini"). Thus Spring wires the Primary bean to this Object.

            Now, as we have defined the name of the Bean we are looking for, thus we have the bean of vehicle as
            "Vehicle_BMW".
         */
        this.vehicle = vehicle;
    }
}

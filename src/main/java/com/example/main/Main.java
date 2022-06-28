package com.example.main;

import com.example.beans.Driver;
import com.example.beans.Passenger;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is : " + vehicle.getName());

        /*
            With this line we are getting the context of this project as defined in the ProjectConfig class.
            AnnotationConfigApplicationContext is an implementation of the ApplicationContext Interface which helps us
                in creating beans in the system.

            This way spring will add all the beans in the Spring IOC Container context created.
         */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
            Having 2 beans of same class type returns 'NoUniqueBeanFoundException'...
            To overcome this we need to specify the bean name as well as its type in the getBean method.
         */
        Vehicle vehicle1 = context.getBean("BMW_Car", Vehicle.class);
        System.out.println("Vehicle name from the Spring Context is : " + vehicle1.getName());

        Vehicle vehicle2 = context.getBean("Lamborghini_Car", Vehicle.class);
        System.out.println("Vehicle name from the Spring Context is : " + vehicle2.getName());

        /*
            We do not need to do any explicit casting while fetching a bean from context. Spring is smart enough to look
             for a bean of the type you requested in its context. If such a bean does not exist, Spring will throw an
            exception.
         */
        var hello = context.getBean(String.class);
        System.out.println("Value obtained from the string context is : " + hello);
        var number = context.getBean(Integer.class);
        System.out.println("Value obtained from the string context is : " + number);

        Driver driver = context.getBean(Driver.class);
        System.out.println("Driver name is : " + driver.getName());
        driver.printAbout();

        addPassengers(context);

        Map<String, Passenger> passengers = context.getBeansOfType(Passenger.class);
        System.out.println("The vehicle has " + passengers.size() + " passenger(s).");
        for (String name : passengers.keySet())
            System.out.println("Passenger : " + name +", has gender : " + passengers.get(name).getGender() + ".");

        context.close();
    }

    static void addPassengers(AnnotationConfigApplicationContext context) {

        Supplier<Passenger> passengerSupplier1 = () -> {
            Passenger passenger = new Passenger();
            passenger.setName("Passenger 1");
            passenger.setGender(Passenger.Gender.MALE);
            return passenger;
        };

        Supplier<Passenger> passengerSupplier2 = () -> {
            Passenger passenger = new Passenger();
            passenger.setName("Passenger 2");
            passenger.setGender(Passenger.Gender.FEMALE);
            return passenger;
        };

        Random random = new Random();
        int numberOfPassenger = random.nextInt(1,5);

        for (int i = 0; i < numberOfPassenger; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("passenger").append(i);
            int choice = random.nextInt(1,3);
            if(choice == 1)
                context.registerBean(stringBuilder.toString(), Passenger.class, passengerSupplier1);
            else
                context.registerBean(stringBuilder.toString(), Passenger.class, passengerSupplier2);
        }
    }

}

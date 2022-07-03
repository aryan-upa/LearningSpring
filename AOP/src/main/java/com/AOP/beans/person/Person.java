package com.AOP.beans.person;

import com.AOP.beans.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    private final Vehicle vehicle;

    @Autowired
    Person(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "--------- Vehicle Details ----------\n" +
                "Tyre type : " + vehicle.getVehicleServices().getTyre().toString() +
                "\nSound System type : " + vehicle.getVehicleServices().getMusicSystem().toString();
    }
}

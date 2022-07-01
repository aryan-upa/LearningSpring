package com.assignment.beans.person;

import com.assignment.beans.vehicle.Vehicle;
import com.assignment.beans.vehicleServices.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    private Vehicle vehicle;

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

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void drive() {
        VehicleServices services = getVehicle().getVehicleServices();
        services.getTyre().rotate();
        services.getMusicSystem().makeSound();
    }

    @Override
    public String toString() {
        return "--------- Vehicle Details ----------\n" +
                "Tyre type : " + vehicle.getVehicleServices().getTyre().toString() +
                "\nSound System type : " + vehicle.getVehicleServices().getMusicSystem().toString();
    }
}

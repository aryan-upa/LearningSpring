package com.example.beans;

public class Registration {
    private String registrationNumber;

    public Registration() {
        System.out.println("Registration in Process...");
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}

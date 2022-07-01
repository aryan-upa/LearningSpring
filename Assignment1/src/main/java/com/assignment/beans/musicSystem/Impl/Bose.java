package com.assignment.beans.musicSystem.Impl;

import com.assignment.beans.musicSystem.Speakers;
import org.springframework.stereotype.Component;

@Component
public class Bose implements Speakers {

    public static final String SPEAKER_COMPANY = "Bose Speakers";

    @Override
    public void makeSound() {
        System.out.println("Playing some Sounds.");
    }

    @Override
    public String toString() {
        return "Make of : " + SPEAKER_COMPANY;
    }

}

package com.assignment.beans.musicSystem.Impl;

import com.assignment.beans.musicSystem.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sony implements Speakers {

    public static final String SPEAKER_COMPANY = "Sony Speakers";

    @Override
    public void makeSound() {
        System.out.println("Playing some Sounds.");
    }

    @Override
    public String toString() {
        return "Make of : " + SPEAKER_COMPANY;
    }
}

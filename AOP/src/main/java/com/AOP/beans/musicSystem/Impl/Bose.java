package com.AOP.beans.musicSystem.Impl;

import com.AOP.beans.musicSystem.Speakers;
import com.AOP.generic.classes.Song;
import org.springframework.stereotype.Component;

@Component
public class Bose implements Speakers {
    public static final String SPEAKER_COMPANY = "Bose Speakers";

    @Override
    public void makeSound(Song song) {
        System.out.println("Now Playing : " + song.getName() + "\nBy : " + song.getArtist());
    }

    @Override
    public String toString() {
        return "Make of : " + SPEAKER_COMPANY;
    }

}

package com.AOP.beans.musicSystem.Impl;

import com.AOP.beans.musicSystem.Speakers;
import com.AOP.generic.classes.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sony implements Speakers {

    public static final String SPEAKER_COMPANY = "Sony Speakers";

    @Override
    public void makeSound(Song song) {
        System.out.println("Now Playing : " + song.name() + "\nBy : " + song.artist());
    }

    @Override
    public String toString() {
        return "Make of : " + SPEAKER_COMPANY;
    }
}

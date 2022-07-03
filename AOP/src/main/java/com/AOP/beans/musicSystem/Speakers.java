package com.AOP.beans.musicSystem;

import com.AOP.generic.classes.Song;
import org.springframework.stereotype.Service;

@Service
public interface Speakers {
    void makeSound(Song song);
}

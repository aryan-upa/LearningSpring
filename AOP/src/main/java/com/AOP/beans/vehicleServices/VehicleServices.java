package com.AOP.beans.vehicleServices;

import com.AOP.beans.aspects.LoggerAspect;
import com.AOP.beans.musicSystem.Speakers;
import com.AOP.beans.tyre.Tyre;
import com.AOP.generic.classes.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VehicleServices {

    private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    private final Tyre tyre;
    private final Speakers musicSystem;

    @Autowired
    public VehicleServices(Tyre tyre, Speakers musicSystem) {
        this.tyre = tyre;
        this.musicSystem = musicSystem;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public Speakers getMusicSystem() {
        return musicSystem;
    }

    public String doPlay(boolean isVehicleStarted, Song song){
        musicSystem.makeSound(song);
        return "Method Successful!!";
    }

    public String doDrive(boolean isVehicleStarted) {
        tyre.rotate(true);
        return "Method Successful!!";
    }
}

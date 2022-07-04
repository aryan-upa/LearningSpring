package com.AOP.beans.vehicleServices;

import com.AOP.annotations.LogAspect;
import com.AOP.annotations.LogCompletion;
import com.AOP.annotations.LogException;
import com.AOP.beans.musicSystem.Speakers;
import com.AOP.beans.tyre.Tyre;
import com.AOP.generic.classes.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

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

    @LogAspect
    @LogException
    @LogCompletion
    public String doPlay(boolean isVehicleStarted, Song song){
        musicSystem.makeSound(song);
        return "Method Successful!!";
    }

    @LogAspect
    @LogException
    @LogCompletion
    public String doDrive(boolean isVehicleStarted) {
        tyre.rotate(true);
        return "Method Successful!!";
    }
}

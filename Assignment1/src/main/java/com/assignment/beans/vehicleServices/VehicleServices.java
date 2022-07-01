package com.assignment.beans.vehicleServices;

import com.assignment.beans.musicSystem.Speakers;
import com.assignment.beans.tyre.Tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    private Tyre tyre;
    private Speakers musicSystem;

    @Autowired
    public VehicleServices(Tyre tyre, Speakers musicSystem) {
        this.tyre = tyre;
        this.musicSystem = musicSystem;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Speakers getMusicSystem() {
        return musicSystem;
    }

    public void setMusicSystem(Speakers musicSystem) {
        this.musicSystem = musicSystem;
    }
}

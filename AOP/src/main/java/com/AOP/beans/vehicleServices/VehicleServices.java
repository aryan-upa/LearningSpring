package com.AOP.beans.vehicleServices;

import com.AOP.beans.musicSystem.Speakers;
import com.AOP.beans.tyre.Tyre;
import com.AOP.generic.classes.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VehicleServices {

    private final Logger logger = Logger.getLogger(VehicleServices.class.getName());

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

    public void play(boolean isVehicleStarted, Song song) {
        Instant start = Instant.now();
        logger.info("method execution start");

        if(isVehicleStarted) {
            musicSystem.makeSound(song);
        }
        else {
            logger.log(Level.SEVERE, "Vehicle not started, unable to play music.");
        }

        logger.info("method execution ended");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time taken to execute the method : " + timeElapsed);
    }

    public void drive(boolean isVehicleStarted) {
        Instant start = Instant.now();
        logger.info("method execution start");

        if(isVehicleStarted) {
            tyre.rotate(true);
        }
        else {
            logger.log(Level.SEVERE, "Vehicle not started, unable to drive vehicle.");
        }

        logger.info("method execution ended");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time taken to execute the method : " + timeElapsed);

    }
}

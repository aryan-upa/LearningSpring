package com.AOP.beans.tyre.Impl;

import com.AOP.beans.tyre.Tyre;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyre implements Tyre {

    public static final String TYRE_COMPANY = "Michelin";

    @Override
    public void rotate(boolean isVehicleStarted) {
        System.out.println("Tyres are Rotating... ");
    }

    @Override
    public String toString() {
        return "Make of : " + TYRE_COMPANY;
    }
}

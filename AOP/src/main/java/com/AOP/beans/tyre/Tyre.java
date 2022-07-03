package com.AOP.beans.tyre;

import org.springframework.stereotype.Service;

@Service
public interface Tyre {
    void rotate(boolean isVehicleStarted);
}

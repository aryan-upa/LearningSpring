package com.AOP.beans.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(1)
public class VehicleStartCheckAspect {

    /*
        While defining a before advice we need to define inside the "methods regex", if we are using a variable or not.
        Also, we need to define the order in which we want the execution of Aspects to take place.
        In Before executions we need to have JoinPoint parameter, in @Around aspect we can have PrecedingJoinPoint which
         can be used as we have a choice whether to proceed with the join point or not, but in other aspects we do not
        have such choice.
     */

    @Before("execution(* com.AOP.beans.vehicleServices.VehicleServices.do*(..)) && args(isVehicleStarted,..)")
    public void isVehicleStarted(JoinPoint joinPoint, boolean isVehicleStarted) throws RuntimeException {
        if(!isVehicleStarted)
            throw new RuntimeException("Unable to Start Vehicle!!");
    }
}

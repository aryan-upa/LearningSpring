package com.AOP.beans.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Component
@Aspect
@Order(2)
public class LoggerAspect {

    private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    /*
        We are using regex to define a single-single methods in the VehicleServices class
        to use 2 different functions in regex, we are using '||' Or operator.
     */
    @Around("execution(* com.AOP.beans.vehicleServices.VehicleServices.doDrive(..)) || " +
            "execution(* com.AOP.beans.vehicleServices.VehicleServices.doPlay(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() + " method execution start.");
        Instant start = Instant.now();

        joinPoint.proceed();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : " + timeElapsed );
        logger.info(joinPoint.getSignature().toString() + " method execution ended.");
    }

}

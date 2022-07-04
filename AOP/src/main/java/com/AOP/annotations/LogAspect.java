package com.AOP.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAspect  {
    /*
        Retention has to be RUNTIME. As Spring injects these methods at Runtime only.

        This is another method of telling aspect methods which methods at runtime they need to attach themselves to, to
        tell the aspect methods which annotation to look for we specify the advice configuration as :
            ex : @Around("annotation(com.AOP.annotations.LogAspect)")
        tells the aspect method to look for this annotation.
     */

    // These only have to be of Placeholder type.
}

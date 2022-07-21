package com.LearningSpring.SchoolProject.annotations;

import com.LearningSpring.SchoolProject.validators.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

    String message() default "Weak Password!";

}

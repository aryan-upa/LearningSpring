package com.LearningSpring.SchoolProject.validators;

import com.LearningSpring.SchoolProject.annotations.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    List<String> passwords;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        passwords = List.of("12345", "user1234", "123456789", "password");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !passwords.contains(value);
    }
}

package com.LearningSpring.SchoolProject.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Profile {

    @NotBlank(message = "Name can not be blank!")
    @Size(min = 3, message = "Name value must be at lease of 3 characters.")
    private String name;

    @NotBlank(message = "Phone number can not be blank!")
    @Pattern(regexp = "^$|\\d{10}", message = "Phone number not valid")
    private String phoneNumber;

    @NotBlank(message = "Email can not be blank!!")
    @Email(message = "Invalid email!")
    private String email;

    @NotBlank(message = "Address can not be blank!!")
    @Size(min = 3, message = "Address must be of at least 3 characters")
    private String address1;

    private String address2;

    @NotBlank(message = "City can not be blank!!")
    @Size(min = 3, message = "City must be at least 3 characters long..")
    private String city;

    @NotBlank(message = "State can not be Empty!")
    @Size(min = 3, message = "State must be at least 3 characters long..")
    private String state;

    @NotBlank(message = "ZipCode can not be empty!")
    @Pattern(regexp = "^$|\\d{6}", message = "Invalid ZipCode..")
    private String zipCode;

}

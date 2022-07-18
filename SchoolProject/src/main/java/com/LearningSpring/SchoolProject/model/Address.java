package com.LearningSpring.SchoolProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    int addressId;

    @NotBlank(message = "Address can not be blank!!")
    @Size(min = 3, message = "Address must be of at least 3 characters")
    String address1;

    String address2;

    @NotBlank(message = "City can not be blank!!")
    @Size(min = 3, message = "City must be at least 3 characters long..")
    String city;

    @NotBlank(message = "State can not be Empty!")
    @Size(min = 3, message = "State must be at least 3 characters long..")
    String state;

    @NotBlank(message = "ZipCode can not be empty!")
    @Pattern(regexp = "^$|\\d{6}", message = "Invalid ZipCode..")
    int zipCode;


}

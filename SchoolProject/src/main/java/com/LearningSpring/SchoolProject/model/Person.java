package com.LearningSpring.SchoolProject.model;

import com.LearningSpring.SchoolProject.annotations.FieldsValueMatch;
import com.LearningSpring.SchoolProject.annotations.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Entity
@Component
@FieldsValueMatch.List({
    @FieldsValueMatch(
            field = "pwd",
            fieldMatch = "confirmPwd",
            message = "Password and Confirm Password do not match!!"
    ),
    @FieldsValueMatch(
            field = "email",
            fieldMatch = "confirmEmail",
            message = "Email and Confirm Email do not match!!"
    )
})
public class Person extends BaseEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    Integer personId;

    @NotBlank(message = "Name can not be blank!")
    @Size(min = 3, message = "Name value must be at lease of 3 characters.")
    String name;

    @NotBlank(message = "Phone number can not be blank!")
    @Pattern(regexp = "^$|\\d{10}", message = "Phone number not valid")
    String phoneNumber;

    @NotBlank(message = "Email can not be blank!!")
    @Email(message = "Invalid email!")
    String email;

    @NotBlank(message = "Confirm Email can not be blank!!")
    @Email(message = "Invalid email!")
    @Transient // Ignore these fields for any Database related operations.
    String confirmEmail;

    @NotBlank(message = "Password can not be Empty!")
    @Size(min = 5, message = "Password has to be at least 5 characters long!")
    @PasswordValidator(message = "Weak Password, choose another password")
    String pwd;

    @NotBlank(message = "Password can not be Empty!")
    @Size(min = 5, message = "Confirm Password has to be at least 5 characters long!")
    @Transient
    String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
    private Roles roles;

}

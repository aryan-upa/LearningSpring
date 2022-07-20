package com.LearningSpring.SchoolProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "contact_id")
    private int contactID;

    /*
        @NotNull: Checks if a given field is not null but allows empty values & zero inside collection.
        @NotEmpty: Checks if a given field is not null and its size/length is greater than zero.
        @NotBlank: Checks if a given field is not null and trimmed length is greater than zero.
     */

    @NotBlank(message = "Name must not be blank!")
    @Size(min = 3, message = "Name must be at least 3 characters long.")
    String name;

    @NotBlank(message = "Mobile number must not be blank!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!")
    String mobileNum;

    @NotBlank(message = "Email can not be null!!")
    @Email
    String email;

    @NotBlank(message = "Subject can not be blank!")
    @Size(min = 5, message = "Subject should be at least 5 characters long!")
    String subject;

    @NotBlank(message = "Message should not be blank!")
    @Size(min = 10, message = "Message should be 10 characters long!")
    String message;

    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactID, contact.contactID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.Bargunyo.PersonDB.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message="First Name can not be empty.")
    private String name;

    @NotEmpty(message="Last Name can not be empty.")
    private String lastName;

    @Email(message="Email must be valid.")
    @NotEmpty(message="Email can not be empty.")
    private String email;

    @Past(message="Date of birth must be in the past.")
    @NotNull(message="Date of Birth can not be nul.")
    private LocalDate dob;

    @NotNull(message="Salary can not be null.")
    @DecimalMin(value="5000", message="Salary must be at least 5000")
    @Positive
    private BigDecimal salary;

    private String photoFileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

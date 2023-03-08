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


    /*
    * This method for parsing de csvLine will depend
    * on de format of the csvFile
    * */

    public static Person parse(String csvLine) {

        //we split the line in fields, which are separated by comas
        String[] fields = csvLine.split(";\\s*");

            System.out.println(csvLine);

        LocalDate.of(1980,7,9);

        //The date field is number 10
        LocalDate dob = LocalDate.parse(fields[3],DateTimeFormatter.ofPattern("M/d/yyyy"));

        //the first field, the id, will be provided by the program
        //the third field is the name, the fifth is the lastName, etc...
        return new Person(null, fields[0], fields[1], fields[2], dob, new BigDecimal(fields[4]),null);
    }
}

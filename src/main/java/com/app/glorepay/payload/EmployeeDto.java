package com.app.glorepay.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * employee name should not be null and should have a minimum of 3 characters
      * employee email should not be null or blank and should be a valid email
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @Size(min=3,message = "Employee name should have 3 characters minimum")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    private final Integer maxLimit = 5000;
}

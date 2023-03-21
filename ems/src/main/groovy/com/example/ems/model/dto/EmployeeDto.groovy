package com.example.ems.model.dto

import com.example.ems.model.Employee
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.Email
import lombok.Data

@Data
class EmployeeDto {

    @NotEmpty(message = "The full name is required")
    @Size(min = 2, max = 100, message = "The length of full name should be between 2 and 100")
    String firstName;

    @Size(min = 2, max = 100, message = "The length of full name should be between 2 and 100")
    String lastName;

    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.") // regexp and flags (parameters) allow to specify an additional regular expression (including regular expression flags) which the email must match.
    String email;

    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        return employee;

    }

}

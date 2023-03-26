package com.example.ems.model.dto

import com.example.ems.exceptions.ResourceNotFoundException
import com.example.ems.model.Department
import com.example.ems.model.Employee
import com.example.ems.repository.DepartmentRepository
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import lombok.Data
import org.springframework.beans.factory.annotation.Autowired

class EmployeeDto {

    @NotEmpty(message = "The full name is required")
    @Size(min = 2, max = 100, message = "The length of first name should be between 2 and 100")
    String firstName;

    @Size(min = 0, max = 100, message = "The length of last name should be between 2 and 100")
    String lastName;

    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.") // regexp and flags (parameters) allow to specify an additional regular expression (including regular expression flags) which the email must match.
    String email;

    @NotNull(message = "The department should be given")
    Long departmentId;


}

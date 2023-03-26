package com.example.ems.model.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

class DepartmentDto {

    @NotEmpty(message = "Department name should not be empty")
    @Size(min = 5,max=100,message = "Department name should be between 5-100 characters")
    String name;
}

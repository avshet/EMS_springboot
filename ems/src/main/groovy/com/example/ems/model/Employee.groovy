package com.example.ems.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.Data
import org.hibernate.annotations.GenericGenerator

@Data
@Entity
class Employee {

//    @Id
//    @GeneratedValue
    @Id
    @GenericGenerator(name="custom_emp", strategy = "com.example.ems.other.EmployeeIdGenerator")
    @GeneratedValue(generator = "custom_emp")
    @Column(columnDefinition = "varchar(50)")
    String id;

    @Column(nullable = false)
    String firstName;

    @Column
    String lastName;

    @Column(unique = true,nullable = false,columnDefinition = "varchar(50)")
    String email;

    public Employee(){

    }
    public Employee(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //fields in groovy should not be made public because default getter and setter won't be generated if fields are private
}

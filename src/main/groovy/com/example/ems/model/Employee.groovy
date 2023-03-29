package com.example.ems.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import org.hibernate.annotations.GenericGenerator

//@Data
@Entity
class Employee {

    @Id
    @GenericGenerator(name="custom_emp", strategy = "com.example.ems.other.EmployeeIdGenerator")
    @GeneratedValue(generator = "custom_emp")
    @Column(columnDefinition = "varchar(50)")
    String id;

    @Column(nullable = false)
    String firstName;

    @Column
    String lastName;

    @Column(unique = true,nullable = false,columnDefinition = "varchar(199)")
    String email;

    @ManyToOne
    @JsonIgnore
    Department department;

    @ManyToMany
    @JsonIgnore
    List<Employee> whiteList;

    @ManyToMany(mappedBy = "whiteList")
    @JsonIgnore
    List<Employee> whiteListOf;

    public Employee(){

    }
    public Employee(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //fields in groovy should not be made public because default getter and setter won't be generated if fields are private
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}

package com.example.ems.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true,nullable = false,columnDefinition = "varchar(199)")
    String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "Id=" + Id +
                ", departmentName='" + name + '\'' +
                '}';
    }
}

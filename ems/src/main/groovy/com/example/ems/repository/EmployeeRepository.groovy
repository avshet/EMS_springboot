package com.example.ems.repository

import com.example.ems.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository //Not required since JpaRepository implementation have already used @Repository
interface EmployeeRepository extends JpaRepository<Employee,String>{

}
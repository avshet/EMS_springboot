package com.example.ems.repository

import com.example.ems.model.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository extends JpaRepository<Department,Long>{
}

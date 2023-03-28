package com.example.ems.service

import com.example.ems.model.Department
import org.springframework.data.domain.Page

interface DepartmentService {
    Page<Department> findAllDepartments(int page, int size);
    List<Department> findAllDepartments();
    Department findDepartmentById(Long id);
}
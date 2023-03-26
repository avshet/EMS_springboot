package com.example.ems.service.serviceimp

import com.example.ems.exceptions.ResourceNotFoundException
import com.example.ems.model.Department
import com.example.ems.repository.DepartmentRepository
import com.example.ems.service.DepartmentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class DepartmentServiceImp implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;

    }
    @Override
    Page<Department> findAllDepartments(int page, int size) {
        return departmentRepository.findAll(PageRequest.of(page,size))
    }

    @Override
    Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department doesn't exist"));
    }
}

package com.example.ems.controller

import com.example.ems.model.Department
import com.example.ems.service.DepartmentService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/app/department")
class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public Page<Department> findAll(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        int page = offset/limit;
        int size = limit;
        return departmentService.findAllDepartments(page,size);
    }

    @GetMapping("{id}")
    public Department findById(@PathVariable("id") Long id){
        return departmentService.findDepartmentById(id);
    }
}

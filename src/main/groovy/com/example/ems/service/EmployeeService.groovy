package com.example.ems.service

import com.example.ems.model.Employee
import org.springframework.data.domain.Page

interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeByID(String id);

    Employee updateEmployee(Employee employee, String id);

    void deleteEmployee(String id);

    Page<Employee> findPaginated(int page, int size);
}
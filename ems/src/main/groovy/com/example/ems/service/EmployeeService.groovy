package com.example.ems.service

import com.example.ems.model.Employee
import org.springframework.data.domain.Page

interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeByID(Long id);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(long id);

    Page<Employee> findPaginated(int page, int size);
}
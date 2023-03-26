package com.example.ems.service;

public interface EmployeeService
 {
 com.example.ems.model.Employee saveEmployee(com.example.ems.model.Employee employee);
 java.util.List<com.example.ems.model.Employee> getAllEmployee();
 com.example.ems.model.Employee getEmployeeByID(java.lang.Long id);
 com.example.ems.model.Employee updateEmployee(com.example.ems.model.Employee employee, java.lang.Long id);
 void deleteEmployee(long id);
 org.springframework.data.domain.Page<com.example.ems.model.Employee> findPaginated(int page, int size);
}

package com.example.ems.other

import com.example.ems.model.Department
import com.example.ems.model.Employee
import com.example.ems.repository.DepartmentRepository
import com.example.ems.repository.EmployeeRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return (args) -> {

            for (int j = 0 ; j<5;j++) {
                Department department = new Department(name: "dept" + j);
                List<Employee> employeeList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    Employee employee = new Employee("emp" + i, "last" + i * 4, "emp" + j+i + "@gmail.com");
                    employeeList.add(employee)
                    employee.setDepartment(department);
                }
                department.setEmployees(employeeList);
                departmentRepository.save(department)
            }
        };
    }
}

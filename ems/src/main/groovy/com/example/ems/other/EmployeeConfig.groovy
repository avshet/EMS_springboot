package com.example.ems.other

import com.example.ems.model.Employee
import com.example.ems.repository.EmployeeRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return (args) -> {

            for (int i = 0; i < 25; i++) {
                Employee employee = new Employee("emp" + i, "last" + i * 4, "emp" + i + "@gmail.com");
                repository.save(employee);
            }
        };
    }
}

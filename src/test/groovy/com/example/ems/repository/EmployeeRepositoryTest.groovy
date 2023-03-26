package com.example.ems.repository

import com.example.ems.exceptions.ResourceNotFoundException
import com.example.ems.model.Employee
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void checkForSave(){
        String email = "athreyavshet@gmail.com";
        Employee employee = new Employee(firstName: "Athreya",lastName: "Shet",email:email);
        employeeRepository.save(employee);
        Assertions.assertThat(employee.getId()).isNotNull()
    }

    @Test
    public void getEmployeeById(){
        Employee employee = new Employee(firstName: "Athreya",lastName: "Shet",email:"athreyavshet@gmail.com");
        employeeRepository.save(employee);
        print(employee.getId())
        Employee employeeTest = employeeRepository.findById(employee.getId()).orElseThrow(()->new ResourceNotFoundException("ID doesn't exist emp-01"))
        Assertions.assertThat(employeeTest.getId()).isEqualTo(employee.getId());
    }

    @Test
    public void updateEmployeeById(){
        Employee employee = new Employee(firstName: "Athreya",lastName: "Shet",email:"athreyavshet@gmail.com");
        employeeRepository.save(employee);
        Employee employeeSaved = employeeRepository.findById(employee.getId()).get();
        employeeSaved.setEmail("ram@gmail.com");
        Employee employeeUpdated =  employeeRepository.save(employeeSaved);
        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("ram@gmail.com");
    }

    @Test
    public void deleteEmployeeTest(){
        Employee employee = new Employee(firstName: "Athreya",lastName: "Shet",email:"athreyavshet@gmail.com");
        employeeRepository.save(employee);
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        employeeRepository.deleteById(savedEmployee.getId());

        Employee employee1 = null;

        Optional<Employee> optionalEmployee = employeeRepository.findById(savedEmployee.getId());

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }
        Assertions.assertThat(employee1).isNull();
    }
}
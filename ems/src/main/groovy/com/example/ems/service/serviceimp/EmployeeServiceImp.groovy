package com.example.ems.service.serviceimp

import com.example.ems.exceptions.ResourceNotFoundException
import com.example.ems.model.Employee
import com.example.ems.repository.EmployeeRepository
import com.example.ems.service.EmployeeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    Employee getEmployeeByID(Long id) {
//        Optional<Employee> result = employeeRepository.findById(id);
//        if(result.isPresent()){
//            return result.get();
//        }
//        else{
//            throw new ResourceNotFoundException("Employee","ID",id);
//        }

        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID doesn't exist "+id));
    }

    @Override
    Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById((id)).orElseThrow(()->new ResourceNotFoundException("ID doesn't exist "+id));
        existingEmployee.firstName = employee.firstName;
        existingEmployee.lastName = employee.lastName;
        existingEmployee.email = employee.email;

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    void deleteEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById((id)).orElseThrow(()->new ResourceNotFoundException("ID doesn't exist "+id));
        employeeRepository.deleteById(id);
    }

    @Override
    Page<Employee> findPaginated(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page,size));
    }
}

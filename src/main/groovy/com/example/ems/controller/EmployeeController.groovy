package com.example.ems.controller

import com.example.ems.exceptions.ResourceNotFoundException
import com.example.ems.model.Department
import com.example.ems.model.Employee
import com.example.ems.model.dto.EmployeeDto
import com.example.ems.repository.DepartmentRepository
import com.example.ems.service.serviceimp.DepartmentServiceImp
import com.example.ems.service.serviceimp.EmployeeServiceImp
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("app/employee")
class EmployeeController {

    @Autowired
    private final DepartmentServiceImp departmentServiceImp;
    @Autowired
    private final EmployeeServiceImp employeeServiceImp;


    // GET /emp => All employees
    // GET /emp/:id => One employee
    // POST /emp => Create employee (ReqBody)
    // PUT/PATCH /emp/:id => Update employee
    // DELETE /emp/:id => Delete employee

    // Idempotent =>
    //Get Employee by ID
    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") String id) {
        return new ResponseEntity<Employee>(employeeServiceImp.getEmployeeByID(id), HttpStatus.OK);
    }

    //Update Employee
    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @Valid @RequestBody EmployeeDto employeeDto) {
        Employee updatedEmployee = employeeServiceImp.updateEmployee(toEmployee(employeeDto),id);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    //Add/save an Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = toEmployee(employeeDto)
        Employee createdEmployee = employeeServiceImp.saveEmployee(employee);
        return new ResponseEntity<Employee>(createdEmployee, HttpStatus.CREATED);
    }

    //Delete an Employee
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam("id") String id) {
        return new ResponseEntity<String>(employeeServiceImp.deleteEmployee(id), HttpStatus.OK);
    }

    //Get paginated list of Employee
    @GetMapping("/list")
    public List<Employee> getEmployeesPaginated(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        int page = (int) (offset / limit);
        int size = limit;
        Page<Employee> employeePage = employeeServiceImp.findPaginated(page, size);
        if (page > employeePage.getTotalPages()) {
            throw new ResourceNotFoundException("Employees doesn't exist");
        }

        return employeePage.getContent();
    }
    public Employee toEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.firstName);
        employee.setLastName(employeeDto.lastName);
        employee.setEmail(employeeDto.email);
        Department department = departmentServiceImp.findDepartmentById(employeeDto.departmentId)
        employee.setDepartment(department);
        return employee;
    }
}

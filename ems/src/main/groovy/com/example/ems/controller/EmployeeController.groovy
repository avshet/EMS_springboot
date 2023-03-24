package com.example.ems.controller

import com.example.ems.exceptions.ResourceNotFoundException
import com.example.ems.model.Employee
import com.example.ems.model.dto.EmployeeDto
import com.example.ems.service.serviceimp.EmployeeServiceImp
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("app/employee")
class EmployeeController {

//    @Autowired
    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp){
        this.employeeServiceImp = employeeServiceImp;
    }
    //T_ODO:: Include validation Request object for every entity value to be updated
    //T_ODO:: Validate every field of entity, email should be unique, type should be compatible, null values
    //T_ODO:: Change Page and size to Offset and limit (understand the concepts)
    //T_ODO:: Include better uri than currently given(tech fields)
    //T_ODO:: Work on Http responses generated (50x-40x), customize response "First name cannot be null"
    //T_ODO:: Employee Request Object
    //T_ODO:: Id needs to be generated dynamically with string.


    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") String id ){
        return new ResponseEntity<Employee>(employeeServiceImp.getEmployeeByID(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeServiceImp.updateEmployee(employee,id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        Employee createdEmployee = employeeServiceImp.saveEmployee(employeeDto.toEmployee());
        return new ResponseEntity<Employee>(createdEmployee,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam("id") String id){
        employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
    }


    @GetMapping("/list")
    public List<Employee> getEmployeesPaginated(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        int page = (int) (offset/limit);
        int size = limit;
        Page<Employee> employeePage = employeeServiceImp.findPaginated(page,size);
        if (page > employeePage.getTotalPages()) {
            throw new ResourceNotFoundException("Employees doesn't exist");
        }

        return employeePage.getContent();
    }
}

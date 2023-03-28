package com.example.ems.controller

import com.example.ems.model.Department
import com.example.ems.model.Employee
import com.example.ems.model.dto.EmployeeDto
import com.example.ems.service.serviceimp.DepartmentServiceImp
import com.example.ems.service.serviceimp.EmployeeServiceImp
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Controller
class EmployeeViewController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    private DepartmentServiceImp departmentServiceImp;

    @GetMapping("employees")
    public String getEmployeeList(Model model){
//        model.addAttribute("employees",employeeServiceImp.getAllEmployee());
//        return "employees";
        return findPaginated(0,model);
    }

    @GetMapping("/employees/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int page, Model model){
        int pageSize = 10;
        Page<Employee> employeePage = employeeServiceImp.findPaginated(page,pageSize);
        List<Employee> employeeList = employeePage.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",employeePage.getTotalPages());
        model.addAttribute("totalItems",employeePage.getTotalElements());
        model.addAttribute("employees",employeeList);
        return "employees"
    }

    @GetMapping("/employees/new")
    public String addEmployee(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto",employeeDto);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto){
        Employee createdEmployee = toEmployee(employeeDto)
        employeeServiceImp.saveEmployee(createdEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable("id") String id, Model model){
        Employee employee = employeeServiceImp.getEmployeeByID(id);
        EmployeeDto employeeDto = toEmployeeDto(employee);
        model.addAttribute("employeeDto",employeeDto);
        return "update_employee";
    }

    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable("id") String id,@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto){
        Employee updatedEmployee = toEmployee(employeeDto);
        employeeServiceImp.updateEmployee(toEmployee(employeeDto),id);
        return "redirect:/employees";
    }

    @GetMapping("employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        employeeServiceImp.deleteEmployee(id);
        return "redirect:/employees"
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

    public EmployeeDto toEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.firstName);
        employeeDto.setLastName(employee.lastName);
        employeeDto.setEmail(employee.email);
        Long id = employee.department.getId();
        employeeDto.setDepartmentId(id);
        return employeeDto;
    }

}

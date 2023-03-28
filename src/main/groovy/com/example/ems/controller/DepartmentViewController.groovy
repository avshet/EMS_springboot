package com.example.ems.controller

import com.example.ems.model.Department
import com.example.ems.service.serviceimp.DepartmentServiceImp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DepartmentViewController {

    @Autowired
    private final DepartmentServiceImp departmentServiceImp;

    @GetMapping("/departments")
    public String getAllDepartments(Model model)
    {
        List<Department> departmentList = departmentServiceImp.findAllDepartments();
        model.addAttribute("departments",departmentList);
        return "departments"
    }

}

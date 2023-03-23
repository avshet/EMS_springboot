package com.example.ems.controller;

@org.springframework.web.bind.annotation.RestController() @org.springframework.web.bind.annotation.RequestMapping(value="app/employee") public class EmployeeController
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public EmployeeController
(com.example.ems.service.serviceimp.EmployeeServiceImp employeeServiceImp) {}
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
@org.springframework.web.bind.annotation.GetMapping(value="{id}") public  org.springframework.http.ResponseEntity<com.example.ems.model.Employee> findById(@org.springframework.web.bind.annotation.PathVariable(value="id") java.lang.Long id) { return (org.springframework.http.ResponseEntity<com.example.ems.model.Employee>)null;}
@org.springframework.web.bind.annotation.PostMapping(value="/update/{id}") public  org.springframework.http.ResponseEntity<com.example.ems.model.Employee> updateEmployee(@org.springframework.web.bind.annotation.PathVariable(value="id") java.lang.Long id, @org.springframework.web.bind.annotation.RequestBody() com.example.ems.model.Employee employee) { return (org.springframework.http.ResponseEntity<com.example.ems.model.Employee>)null;}
@org.springframework.web.bind.annotation.PostMapping(value="/add") public  org.springframework.http.ResponseEntity<com.example.ems.model.Employee> addEmployee(@jakarta.validation.Valid() @org.springframework.web.bind.annotation.RequestBody() com.example.ems.model.dto.EmployeeDto employeeDto) { return (org.springframework.http.ResponseEntity<com.example.ems.model.Employee>)null;}
@org.springframework.web.bind.annotation.DeleteMapping(value="/delete") public  org.springframework.http.ResponseEntity<java.lang.String> deleteEmployee(@org.springframework.web.bind.annotation.RequestParam(value="id") java.lang.Long id) { return (org.springframework.http.ResponseEntity<java.lang.String>)null;}
@org.springframework.web.bind.annotation.GetMapping(value="/list") public  java.util.List<com.example.ems.model.Employee> getEmployeesPaginated(@org.springframework.web.bind.annotation.RequestParam(value="limit") int limit, @org.springframework.web.bind.annotation.RequestParam(value="offset") int offset) { return (java.util.List<com.example.ems.model.Employee>)null;}
}

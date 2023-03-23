package com.example.ems.service.serviceimp;

@org.springframework.stereotype.Service() public class EmployeeServiceImp
  extends java.lang.Object  implements
    com.example.ems.service.EmployeeService,    groovy.lang.GroovyObject {
;
public EmployeeServiceImp
(com.example.ems.repository.EmployeeRepository employeeRepository) {}
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
@java.lang.Override() public  com.example.ems.model.Employee saveEmployee(com.example.ems.model.Employee employee) { return (com.example.ems.model.Employee)null;}
@java.lang.Override() public  java.util.List<com.example.ems.model.Employee> getAllEmployee() { return (java.util.List<com.example.ems.model.Employee>)null;}
@java.lang.Override() public  com.example.ems.model.Employee getEmployeeByID(java.lang.Long id) { return (com.example.ems.model.Employee)null;}
@java.lang.Override() public  com.example.ems.model.Employee updateEmployee(com.example.ems.model.Employee employee, java.lang.Long id) { return (com.example.ems.model.Employee)null;}
@java.lang.Override() public  void deleteEmployee(long id) { }
@java.lang.Override() public  org.springframework.data.domain.Page<com.example.ems.model.Employee> findPaginated(int page, int size) { return (org.springframework.data.domain.Page<com.example.ems.model.Employee>)null;}
}

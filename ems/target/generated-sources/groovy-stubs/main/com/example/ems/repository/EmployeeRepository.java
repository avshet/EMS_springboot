package com.example.ems.repository;

@org.springframework.stereotype.Repository() public interface EmployeeRepository
  extends
    org.springframework.data.jpa.repository.JpaRepository<com.example.ems.model.Employee, java.lang.Long> {
}

package com.example.springexample.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springexample.model.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

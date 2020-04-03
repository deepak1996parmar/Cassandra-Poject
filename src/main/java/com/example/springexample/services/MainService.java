package com.example.springexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springexample.model.company.Company;
import com.example.springexample.model.employee.Employee;

@Service
public interface MainService {

	public String save(Employee employee);
	
	public List<Employee> getData();

	public String saveCompany(Company comp);
	
}

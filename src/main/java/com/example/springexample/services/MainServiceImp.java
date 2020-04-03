package com.example.springexample.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springexample.cassandraRepo.NewRepository;
import com.example.springexample.companyRepo.CompanyRepository;
import com.example.springexample.employeeRepo.EmployeeRepository;
import com.example.springexample.model.company.Company;
import com.example.springexample.model.employee.Employee;

import javassist.bytecode.Descriptor.Iterator;

@Component
public class MainServiceImp implements MainService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private NewRepository newRepository;

	@Override
	public String save(Employee employee) {

		newRepository.save(employee);
		return "employee details saved successfully!";
	}

	@Override
	public List<Employee> getData() {

		return employeeRepository.findAll();

	}

	@Override
	public String saveCompany(Company comp) {

		companyRepository.save(comp);
		return "company details saved successfuly";
	}

}

package com.example.springexample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springexample.model.company.Company;
import com.example.springexample.model.employee.Employee;
import com.example.springexample.services.MainService;

@RestController
@RequestMapping("/organization")
public class Controller {

	@Autowired 
	private MainService mainService;

	@GetMapping("/get-employee")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list=mainService.getData();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@PostMapping("/save-employee")
	public ResponseEntity<String> saveEmployees(@RequestBody Employee emp) {
		String resp=mainService.save(emp);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@PostMapping("/save-company")
	public ResponseEntity<String> saveCompany(@RequestBody Company comp) {
		String resp=mainService.saveCompany(comp);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

}

package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.CompanyService;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/employees/{companyId}")
	public void addEmployee(
			@RequestBody Employee employee, 
			@PathVariable String companyId) {
		
		System.out.println("companyId " + companyId);
		employeeService.addEmployeeWithCompany(employee, Long.parseLong(companyId));
	}
	
}

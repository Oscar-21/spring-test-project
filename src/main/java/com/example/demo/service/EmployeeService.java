package com.example.demo.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	public void addEmployeeWithCompany(Employee employee, Long companyId) {
		
		try {
			Company company = companyRepository.findById(companyId).get();
			employee.addCompany(company);
			employeeRepository.save(employee);
		} catch (NoSuchElementException e) {
		}
		
	}
	
}

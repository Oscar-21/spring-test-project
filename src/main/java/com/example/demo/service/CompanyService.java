package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public void addCompany(Company company) {
		// how to verify success or check for sql failure
		// transaction
		companyRepository.save(company);
	}
}

package com.springplayground.demo.service;

import com.springplayground.demo.domain.Company;
import com.springplayground.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void addCompany(Company company) {
        companyRepository.save(company);
    }
}

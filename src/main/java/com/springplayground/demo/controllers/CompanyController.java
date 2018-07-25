package com.springplayground.demo.controllers;

import com.springplayground.demo.domain.Company;
import com.springplayground.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST, value = "/companies")
    public String addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return company.toString();
    }
}

package com.springplayground.demo.service;

import java.util.NoSuchElementException;
import com.springplayground.demo.domain.Company;
import com.springplayground.demo.domain.Employee;
import com.springplayground.demo.repository.CompanyRepository;
import com.springplayground.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public void add(Employee employee, Long companyId) throws NoSuchElementException {
        Company company = companyRepository.findById(companyId).get();
        employee.addCompany(company);
        employeeRepository.save(employee);
    }

    public Employee getById(Long id) throws NoSuchElementException {
        return employeeRepository.findById(id).get();
    }

}

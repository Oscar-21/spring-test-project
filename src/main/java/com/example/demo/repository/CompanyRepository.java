package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}

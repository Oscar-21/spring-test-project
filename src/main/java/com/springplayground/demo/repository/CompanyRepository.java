package com.springplayground.demo.repository;

import com.springplayground.demo.domain.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * CompanyRepository
 */
public interface CompanyRepository extends CrudRepository<Company, Long> {

}

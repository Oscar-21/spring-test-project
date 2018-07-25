package com.springplayground.demo.repository;

import com.springplayground.demo.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * CompanyRepository
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}

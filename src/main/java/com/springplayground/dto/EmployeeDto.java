package com.springplayground.dto;

import com.springplayground.demo.domain.Employee;

/**
 * EmployeeDto
 */
public class EmployeeDto {

    private Long id;
    private String name;
    private Long companyId;

    public EmployeeDto(Employee employee) {
        id = employee.getId();
        name = employee.getName();
        companyId = employee.getCompany().getId();
    }

    /**
     * @return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}

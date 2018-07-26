package com.springplayground.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springplayground.demo.domain.Employee;
import com.springplayground.demo.service.EmployeeService;
import com.springplayground.dto.EmployeeDto;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, value = "/employees/company/{companyId}")
    public ResponseEntity<Map<String, String>> addEmployee(@RequestBody Employee employee,
            @PathVariable String companyId) {

        Map<String, String> response = new HashMap<>();

        try {
            employeeService.add(employee, Long.parseLong(companyId));
            response.put("success", "new employee created");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable String id) {

        try {
            Employee employee = employeeService.getById(Long.parseLong(id));
            return new EmployeeDto(employee);
        } catch (NoSuchElementException e) {
            return new EmployeeDto(new Employee());
        }
    }

}

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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springplayground.demo.domain.Employee;
import com.springplayground.demo.service.EmployeeService;


@RestController
public class EmployeeController {

    // @Autowired
    // private CompanyService companyService;
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
    public String getEmployee(@PathVariable String id) {

        // Map<String, String> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Employee employee = employeeService.getById(Long.parseLong(id));
            return mapper.writeValueAsString(employee);
            // response.put("employee", mapper.writeValueAsString(employee));
            // response.put("companyId", mapper.writeValueAsString(employee.getCompany().getId()));
            // return mapper.writeValueAsString(response);
        } catch (NoSuchElementException e) {
            // response.put("error", e.getMessage());
            return "response";
        } catch (JsonProcessingException e) {
            // response.put("error", e.getMessage());
            return "response";
        }
    }

}

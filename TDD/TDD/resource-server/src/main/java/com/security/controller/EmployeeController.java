package com.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Employee;
import com.security.model.EmployeeRequest;
import com.security.service.EmployeeService;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {

  
    @RequestMapping(value = "/getEmployeesList", produces = "application/json")
    @ResponseBody
    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        
        employee.setId(1);
        employee.setName("santosh");
        employee.setDesignation("Associate");
        employee.setSalary(50000);
        employees.add(employee);
        
        employee = new Employee();
        employee.setId(2);
        employee.setName("samit");
        employee.setDesignation("Associate");
        employee.setSalary(50000);
        employees.add(employee);
        
        return employees;

    }
    
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/add")
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody EmployeeRequest employeeRequest) {
        boolean saved = employeeService.save(employeeRequest);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            throw new EmployeeNotCreatedException();
        }

    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public ResponseEntity<Boolean> isEmployeeInventory(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.existsById(id));
    }

    public static class EmployeeNotCreatedException extends RuntimeException {
    }

  
}

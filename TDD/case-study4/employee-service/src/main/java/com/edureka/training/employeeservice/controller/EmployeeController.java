package com.edureka.training.employeeservice.controller;

import com.edureka.training.employeeservice.model.Employee;
import com.edureka.training.employeeservice.model.EmployeeRequest;
import com.edureka.training.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
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

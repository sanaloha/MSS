package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.Employee;
import com.security.model.EmployeeRequest;
import com.security.repository.EmployeeRepositroy;

@Service
public class EmployeeService {
	
	@Autowired
    EmployeeRepositroy employeeRepositroy;

    public boolean save(EmployeeRequest employee) {
        Employee toBeSavedProduct = new EmployeeMapper().map(employee);
        Employee saved = employeeRepositroy.save(toBeSavedProduct);
        return saved != null;
    }

    public Optional<Employee> getEmployee(Integer id){
        return employeeRepositroy.findById(id);
    }

    public boolean existsById(int id) {
        return employeeRepositroy.existsById(id);
    }

    private class EmployeeMapper {
        public Employee map(EmployeeRequest employee) {
            return Employee.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .designation(employee.getDesignation())
                    .salary(employee.getSalary()).build();


        }
    }

}

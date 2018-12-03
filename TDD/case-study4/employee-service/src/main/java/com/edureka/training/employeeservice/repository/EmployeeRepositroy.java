package com.edureka.training.employeeservice.repository;

import com.edureka.training.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositroy extends JpaRepository<Employee,Integer> {
}

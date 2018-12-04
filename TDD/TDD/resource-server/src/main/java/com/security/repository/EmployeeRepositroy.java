package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Employee;

@Repository
public interface EmployeeRepositroy extends JpaRepository<Employee,Integer> {
	
	Optional<Employee> findById(Integer id);
	public boolean existsById(int id);
}

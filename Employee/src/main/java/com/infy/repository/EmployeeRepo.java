package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Employee;


public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
}

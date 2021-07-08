package com.infy.service;
import com.infy.DTO.EmployeeDTO;

import com.infy.Exception.EmployeeException;

public interface EmployeeService {

	public Integer addEmployee(EmployeeDTO employeeDTO)throws EmployeeException;
	public EmployeeDTO getEmployee(Integer empid)throws EmployeeException;
	
	
	public void updateEmployee(Integer empid,Integer age)throws EmployeeException;
	public Integer deleteEmployee(Integer empid)throws EmployeeException;
}

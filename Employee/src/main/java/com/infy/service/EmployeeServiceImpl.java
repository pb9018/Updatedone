package com.infy.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.DTO.EmployeeDTO;
import com.infy.Exception.EmployeeException;
import com.infy.entity.Employee;
import com.infy.repository.EmployeeRepo;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	 @Autowired
	 EmployeeRepo repo;
	 @Override
	 public Integer addEmployee(EmployeeDTO employeeDTO)throws EmployeeException{
//		 Optional<Employee> op=repo.findById(employeeDTO.getEmpid());
//		 if(op.isPresent()) {
//			 throw new EmployeeException("Employee not found");
//		 }
		 Employee e = new Employee();
		 e.setEmpid(employeeDTO.getEmpid());
		 e.setName(employeeDTO.getName());
		 e.setAge(employeeDTO.getAge());
		 
		 repo.save(e);
		 return e.getEmpid();
		 
	 }
	 
	@Override
	 public EmployeeDTO getEmployee(Integer empid)throws EmployeeException{
		 Optional<Employee> op=repo.findById(empid);
		 Employee e=op.orElseThrow(()->new EmployeeException("Employee not found"));
		 EmployeeDTO d=new EmployeeDTO();
		 d.setEmpid(e.getEmpid());
		 d.setName(e.getName());
		 d.setAge(e.getAge());
		return d;
		 
	 }
	@Override
	public void updateEmployee(Integer empid,Integer age)throws EmployeeException{
		 Optional<Employee> op=repo.findById(empid);
		 Employee e=op.orElseThrow(()->new EmployeeException("Employee not found"));
		 //e.setName(name);
//		 e.setEmpid(e.getEmpid());
//		 e.setAge(e.getAge());
		 //repo.save(e);
		 e.setAge(age);
		 repo.save(e);
	}
	
	@Override
	public Integer deleteEmployee(Integer empid)throws EmployeeException{
		Optional<Employee> op=repo.findById(empid);
		 Employee e=op.orElseThrow(()->new EmployeeException("Employee not found"));
		 repo.deleteById(empid);
		 return empid;
	}
	 }


package com.infy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.EmployeeDTO;
import com.infy.Exception.EmployeeException;
import com.infy.service.EmployeeService;
import com.infy.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/Employee")
public class EmployeeAPI {
	@Autowired
	private EmployeeService service;

	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee( @RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		Integer empid=service.addEmployee(employeeDTO);
		String Successmessage="the new employee added with "+empid;
		return new ResponseEntity<String>(Successmessage,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/getEmployee/{empid}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer empid)throws EmployeeException{
		return new ResponseEntity<>(service.getEmployee(empid),HttpStatus.OK);
	}
	
	@PutMapping("/UpdateEmployee/{empid}/{age}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer empid ,Integer age)throws EmployeeException{
		service.updateEmployee( empid,age);
	
		String SuccessMessage="the age is updated for emp"+empid;
		return new ResponseEntity<String>(SuccessMessage,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/DeleteEmployee/{empid}")
	public ResponseEntity<String> deleteEmployee( @PathVariable Integer empid)throws EmployeeException{
		Integer empid2=service.deleteEmployee(empid);
		String SuccessMessage="the Employee is deleted with "+empid;
		return new ResponseEntity<String>(SuccessMessage,HttpStatus.OK);
	}
	
	
}

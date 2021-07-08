package com.infy.DTO;



public class EmployeeDTO {
	
	private Integer empid;
	private String name;
	private Integer age;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empid=" + empid + ", name=" + name + ", age=" + age + "]";
	}
	

}

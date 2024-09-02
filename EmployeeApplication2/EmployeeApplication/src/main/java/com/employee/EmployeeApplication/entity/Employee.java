package com.employee.EmployeeApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  //we want to make this class as persist which means that now Jpa can make tables for this class
public class Employee {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated id's
	int employeeId;
	String employeeName;
	String employeeCity;
	
	public Employee() {
		
	}
	
	public Employee(int employeeId, String employeeName, String employeeCity) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	
	

}

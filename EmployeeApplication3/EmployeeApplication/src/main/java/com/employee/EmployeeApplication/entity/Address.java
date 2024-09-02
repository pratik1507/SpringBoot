package com.employee.EmployeeApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String line1;
	private String line2;
	private String zipCode;
	private String city;
	private String state;
	private String country;
	
	@JsonIgnore  // we added this because when we were not using this the getemployees api was getting stuck into infinite loop and repeating addresses
	@ManyToOne               // you can see in address table one extra column is been created to store the employee id
	private Employee employee;   // if a employee has 3 address you are going to see employee id is been repeated 3 times in address table
	
	public Address(String line1, String line2, String zipCode, String city, String state, String country,Employee employee) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.employee=employee;
	}
	
	public Address() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}

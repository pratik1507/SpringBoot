package com.employee.EmployeeApplication.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String clientName;
	
	@JsonIgnore   // we added this because when we were not using this the getemployees api was getting stuck into infinite loop and repeating projects due to its mappings
	@ManyToMany(mappedBy = "projects")  // now you can traverse from projects to employee and employee to projects
	private List<Employee> employees;
	
	public Project(String name, String clientName) {
		super();
		this.name = name;
		this.clientName = clientName;
	}
	
	public Project() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}

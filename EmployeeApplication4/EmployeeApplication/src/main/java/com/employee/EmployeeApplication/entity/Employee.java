package com.employee.EmployeeApplication.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

 
/*--------------------------- NOTE - CASCADE & Fetch --------------------------------------
 * Cascade.ALL propagates(to produce) all the operations from the parent entity to the child one.
 * Cascade.PERSIST allows you to propagate the save operation from the parent entity to that of the child one
 * In Cascade.All you could save as well as delete the dependent entities but in case of Cascade.Persist you can only save the operation you can't delete.
 * If you try to delete in the details in case of Cascade.PERSIST you will get an error stating that their is a foreign key constraint.
 * Cascasde.REMOVE allows you to delete the entity.
 * 
 * 
 * When you define an entity as eager fetch type, the relationship which is defined as eager that entity is also fetched if the parent entity is fetched.
 */





@Entity  //we want to make this class as persist which means that now Jpa can make tables for this class
public class Employee {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated id's
	int employeeId;
	String employeeName;
	String employeeCity;
	
	//if you provide OneToOne mapping only in one class employee which means that from employee you can get the the information about the but
	// from spouse you can't get the information of employees (basically it is unidirectional ) if you want bi-drectional you mapping you have 
	// to include OneToOne mapping in the employee class as well.
	//@OneToOne(cascade = CascadeType.ALL) // added cascading
	//@OneToOne(cascade = CascadeType.PERSIST)
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
	// As we saw spouse query was loading without initializing as the default fetch type of one to one mapping is eager
	// lets mark it as fetch type lazy and see 
	// when you mark it as fetch type lazy it is not been fetched.
	@JoinColumn(name = "fk_spouse") // used to customize your foreign key name
	private Spouse spouse;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@OneToMany(cascade = CascadeType.PERSIST)
	
	//@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER )
	// Before marking Address as FetchType.EAGER we were getting queries of only employee and spouse as spouse and Employee are one to one mapped.
	// But with FetchType.EAGER we can get now the queries of Address too.
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Address> addresses;
	
	/*
	now in the database one new table is created employee_addresses
	suppose employee 1 has 3 addresses so how it will be stored in that table
	employee_id    address id 
	    1             1
	    1             2
	    1             3
	*/
	
	
	//@ManyToMany(cascade = CascadeType.ALL)      // a new table is created with employee project with emp id and project id columns
	//@ManyToMany(cascade = CascadeType.PERSIST)
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(name = "employee_project", 
			  joinColumns = @JoinColumn(name="fk_employee"),
			  inverseJoinColumns = @JoinColumn(name="fk_project")
	          )
	private Set<Project> projects=new HashSet<>();
	
	
	
	public Employee() {
		
	}
	
	
	public Employee(String employeeName, String employeeCity) {
		super();
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
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

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	// since it is bidirectional mapping whenever you delete a project you have to delete it from both project list and from the project entity
	public void removeProject(Project project) {
		this.projects.remove(project);  // removing from project list 
		project.getEmployees().remove(project); // removing from project entity
	}
	
	public void addProject(Project project) {
		this.projects.add(project);
		project.getEmployees().add(this);
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public void addAddress(Address address) {
		this.addresses=new ArrayList<>();
		this.addresses.add(address);
		address.setEmployee(this);
	}
    
	public void removeAddress(Address address) {
		this.addresses.remove(address);
		address.setEmployee(null);
	}
	
}

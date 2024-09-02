package com.employee.EmployeeApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "spouse")
public class Spouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobno;
	private int age;
	
	@OneToOne(mappedBy = "spouse") //as spouse is mapped by the employee class // there will be no extra column created in the spouse table
	private Employee employee;
	
	public Spouse(String name, String mobno, int age) {
		super();
		this.name = name;
		this.mobno = mobno;
		this.age = age;
	}
	
	public Spouse() {
		
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
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

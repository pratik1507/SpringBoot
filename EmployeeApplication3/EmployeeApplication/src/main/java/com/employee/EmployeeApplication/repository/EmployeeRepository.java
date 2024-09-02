package com.employee.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeApplication.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	/* 
	 * CRUD 
	 * 
	 * getAllEmployees();
	 * getEmployee(id);
	 * updateEmployee(Employee employee);
	 * deleteEmployee(int id);
	 * 
	 * These all basic functions are already present in the JpaRepository so we extended to our repository.
	 * */

}

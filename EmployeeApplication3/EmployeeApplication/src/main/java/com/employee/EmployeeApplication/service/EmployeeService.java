package com.employee.EmployeeApplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service  //to declare the class as service class which contains business logic
public class EmployeeService {
	
	List<Employee> employeeList=new ArrayList<>( Arrays.asList(
			new Employee(1, "First Emp", "Washington"),
			new Employee(2, "second emp", "Ind")
	));
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		//return employeeList;
		return employeeRepository.findAll();
	}

	public Employee getAnEmployee(int id) {
		/*return employeeList.stream().filter(e ->(
				e.getEmployeeId()==id)).findFirst().get(); */
		
		// The above lambda function code is explained in simpler way.
		/*
		    for (Employee e : employeeList) {
		        if (e.getEmployeeId() == id) {
		            return e;
		        }
		    }
		    // If no employee with the given id is found, you might want to return null or throw an exception
		    return null; // or throw new NoSuchElementException("Employee not found");
		*/
		
		return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));

	}
	
	public void createEmployee(Employee employee) {
		//employeeList.add(employee);
		
		ArrayList<Address> addressArrayList=new ArrayList<>();
		
		for(Address address:employee.getAddresses()) {
			addressArrayList.add(new Address(address.getLine1(),address.getLine2(),address.getZipCode(),address.getCity(),
					address.getState(),address.getCountry(),employee));
		}
		employee.setAddresses(addressArrayList);
		employeeRepository.save(employee); // save is function of JPA repository
	}
	
	public void updateEmployee(Employee employee) {
		/* List<Employee> tempEmployee=new ArrayList<>();
		for(Employee emp:employeeList) {
			if(emp.getEmployeeId()==employee.getEmployeeId()) {
				emp.setEmployeeName(employee.getEmployeeName());
				emp.setEmployeeCity(employee.getEmployeeCity());
			}
			tempEmployee.add(emp);
		}
		this.employeeList=tempEmployee; */
		
		if (employeeRepository.existsById(employee.getEmployeeId())) {
	        // Save the updated employee object
	        employeeRepository.save(employee);
	    }else {
	    	System.out.println("Employee doesn't exist");
	    }
	}
	public void deleteEmployee(int id) {
		/*ArrayList<Employee> tempEmployees=new ArrayList<>();
		for(Employee emp:employeeList) {
			if(emp.getEmployeeId()==id) {
				continue;
			}
			tempEmployees.add(emp);
		}
		this.employeeList=tempEmployees;*/
		
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		}else {
			System.out.println("Employee doesn't exit");
		}
	}
}

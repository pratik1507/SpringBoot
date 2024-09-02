package com.employee.EmployeeApplication.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;

@Controller
@ResponseBody // as we are passing body as the response (employeeList) so if you didn't use this annotation you will get an error
              // You can also combine these both annotations as one which is @RestController
//@RestController
public class EmployeeController {
	
	/*
	@RequestMapping("/employees") //by default it will take it as Get request
	public List<Employee> findAllEmployees(){
		List<Employee> employeeList= Arrays.asList(
				new Employee(1, "First Emp", "Washington"),
				new Employee(2, "second emp", "Ind")
		);
		return employeeList;
	}*/
	
	@Autowired // it checks for any dependencies of this file and it injects that particular dependency here.
	EmployeeService employeeService;
	
	@RequestMapping("/employees") //by default it will take it as Get request
	// @GetMapping("/employees")  //instead of request mapping you can use this annotation as well which is more readable and short.
	public List<Employee> findAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping("/employees/{id}")
	// @GetMapping("/employees/{id}")
	public Employee findAnEmployee(@PathVariable int id) {
		return employeeService.getAnEmployee(id);
	}

	@RequestMapping(value="/employees",method=RequestMethod.POST) // by default it will be get mapping so to make it as post we use this
	// @PostMapping("/employees")
	public void creteEmployee(@RequestBody Employee employee) { // as we are going to get employee details from request body
		employeeService.createEmployee(employee);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	// @PutMapping("/employees/{id}") // you can see how shortly we can write the same code
	public void updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/employees/{id}", method = RequestMethod.DELETE)
	// @DeleteMapping("/employees/{id}")
	public List<Employee> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return employeeService.getAllEmployees();
	}
}

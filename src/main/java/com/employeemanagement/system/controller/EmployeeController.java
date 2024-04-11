package com.employeemanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.system.model.Employee;
import com.employeemanagement.system.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(originPatterns = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//localhost:5050/employee
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//localhost:5050/employee/41
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}
	
	//localhost:5050/employee/designation?designation=Manager
	@GetMapping("/designation")
	public List<Employee> getEmployeeByDesignation(@RequestParam(value = "designation") String designation){
		List<Employee> employees = employeeService.getEmployeeByDesignation(designation);
		return employees;
	}
	
	//localhost:5050/employee/department?department=Backend
	@GetMapping("/department")
	public List<Employee> getEmployeeByDepartment(@RequestParam(value = "department") String department){
		List<Employee> employees = employeeService.getEmployeeByDepartment(department);
		return employees;
	}
	
	//localhost:5050/employee/email?email=anush@gmail.com
	@GetMapping("/email")
	public Employee getEmployeeByEmail(@RequestParam(value = "email") String email){
		Employee employee = employeeService.getEmployeeByEmail(email);
		return employee;
	}
	
	//localhost:5050/employee/contact?contact=9876543210
	@GetMapping("/contact")
	public Employee getEmployeeByContactNumber(@RequestParam(value = "contact") String contactNumber){
		Employee employee = employeeService.getEmployeeByContactNumber(contactNumber);
		return employee;
	}
	
		
	
	
	//localhost:5050/employee    + JSON body
	
	//Condition checking is only for postman purpose.
	
	//UI based is already done using multiple endpoints
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		if(employeeService.getEmployeeByEmail(employee.getEmail())!=null) {
			System.out.println("Email already exist");
			return null;
		}
		
		if(employeeService.getEmployeeByContactNumber(employee.getContactNumber())!=null) {
			System.out.println("Contact Number already exist");
			return null;
		}
		
		Employee newEmployee = employeeService.addEmployee(employee);
		return newEmployee;
	}
	
	
	//localhost:5050/employee/
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
//		if(employeeService.getEmployeeByEmail(employee.getEmail())!=null) {
//			System.out.println("Email already exist");
//			return null;
//		}
//		
//		if(employeeService.getEmployeeByContactNumber(employee.getContactNumber())!=null) {
//			System.out.println("Contact Number already exist");
//			return null;
//		}
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return updatedEmployee;
	}
}

package com.employeemanagement.system.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.system.model.Employee;
import com.employeemanagement.system.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findByEmployeeId(id);
	}
	
	public List<Employee> getEmployeeByDesignation(String designation){
		return employeeRepository.findByDesignation(designation);
	}
	
	public List<Employee> getEmployeeByDepartment(String department){
		return employeeRepository.findByDepartment(department);
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	public Employee getEmployeeByContactNumber(String contactNumber) {
		return employeeRepository.findByContactNumber(contactNumber);
	}
	
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}

package com.employeemanagement.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.employeemanagement.system.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	Employee findByEmployeeId(Integer employeeId);
	List<Employee> findByDesignation(String designation);
	Employee findByEmail(String email);
	List<Employee> findByDepartment(String department);
	Employee findByContactNumber(String contactNumber);
}

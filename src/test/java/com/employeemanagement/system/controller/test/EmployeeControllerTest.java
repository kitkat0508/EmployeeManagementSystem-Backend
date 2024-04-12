package com.employeemanagement.system.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.employeemanagement.system.controller.EmployeeController;
import com.employeemanagement.system.model.Employee;
import com.employeemanagement.system.service.EmployeeService;

public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;
	
	public EmployeeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }


	@Test
	public void testGetters() throws Exception {
		Employee employee = new Employee(1, "Anush", "Software Engineer", "1234567890", "anush@gmail.com",
				"Software Department");
		assertEquals(1, employee.getEmployeeId());
		assertEquals("Anush", employee.getEmployeeName());
		assertEquals("Software Engineer", employee.getDesignation());
		assertEquals("1234567890", employee.getContactNumber());
		assertEquals("anush@gmail.com", employee.getEmail());
		assertEquals("Software Department", employee.getDepartment());
	}

	@Test
	public void testSetters() throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("Karthik");
		employee.setDesignation("Manager");
		employee.setContactNumber("0987654321");
		employee.setEmail("karthik@gmail.com");
		employee.setDepartment("Software Department");

		assertEquals(2, employee.getEmployeeId());
		assertEquals("Karthik", employee.getEmployeeName());
		assertEquals("Manager", employee.getDesignation());
		assertEquals("0987654321", employee.getContactNumber());
		assertEquals("karthik@gmail.com", employee.getEmail());
		assertEquals("Software Department", employee.getDepartment());
	}

	@Test
	public void testAddEmployee() {
		Employee employee = new Employee(1, "Anush", "Software Engineer", "1234567890", "anush@gmail.com",
				"Software Department");

		when(employeeService.addEmployee(employee)).thenReturn(employee);

		Employee result = employeeController.addEmployee(employee);

		assertEquals(employee, result);
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(
				new Employee(1, "Anush", "Software Engineer", "1234567890", "anush@gmail.com", "Software Department"));
		employeeList
				.add(new Employee(2, "Karthik", "Manager", "0987654321", "karthik@gmail.com", "Software Department"));

		when(employeeService.getAllEmployees()).thenReturn(employeeList);

		List<Employee> result = employeeController.getAllEmployees();

		assertEquals(employeeList.size(), result.size());
		for (int i = 0; i < employeeList.size(); i++) {
			assertEquals(employeeList.get(i), result.get(i));
		}
	}

}

package com.employeemanagement.system.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.employeemanagement.system.controller.EmployeeController;
import com.employeemanagement.system.model.Employee;
import com.employeemanagement.system.service.EmployeeService;

@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void testGetAllEmployees() throws Exception {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Anush", "Manager", "1234567890", "anush@gmail.com","Frontend"));

		when(employeeService.getAllEmployees()).thenReturn(employees);
		//When employeeService.getAllEmployees is called, the return value is employees.
		//Mockito used for testing

		mvc.perform(get("/employee")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(
						"[{\"employeeId\":1,\"employeeName\":\"Anush\",\"designation\":\"Manager\",\"contactNumber\":\"1234567890\",\"email\":\"anush@gmail.com\",\"department\":\"Frontend\"}]"));
	}
	
	
	@Test
    public void testAddEmployee() throws Exception {
        Employee newEmployee = new Employee(10, "Karthik", "SE", "0987654321", "karthik@gmail.com","Backend");

        when(employeeService.addEmployee(newEmployee)).thenReturn(newEmployee);

        mvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\":10,\"employeeName\":\"Karthik\",\"designation\":\"SE\",\"contactNumber\":\"0987654321\",\"email\":\"karthik@gmail.com\",\"department\":\"Backend\"}"))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json("{\"employeeId\":10,\"employeeName\":\"Karthik\",\"designation\":\"SE\",\"contactNumber\":\"0987654321\",\"email\":\"karthik@gmail.com\"}"));
    }
}

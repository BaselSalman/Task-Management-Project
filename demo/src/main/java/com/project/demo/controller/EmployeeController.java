package com.project.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.demo.entity.Employee;
import com.project.demo.service.EmployeeService;

import pojos.EmpReqByDepId;

@RestController
//@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}

	@GetMapping("/employeeEmail/{email}")
	public Employee getEmployeeByEmail(@PathVariable String email) {
		return service.getEmployeeByEmail(email);
	}

	@PostMapping("/employee")
	public void addEmployee(@RequestBody EmpReqByDepId emp) {
		service.saveEmployee(emp);
	}

	/*@PostMapping("/employee/depId")
	public void addEmployeeByDepartmentId(@RequestBody EmpReqByDepId emp) {
		service.saveEmployeeByDepId(emp);
	}*/

	@PutMapping("/employee{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody EmpReqByDepId emp) {
		service.updateEmployee(id, emp);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.removeEmployee(id);
	}
}

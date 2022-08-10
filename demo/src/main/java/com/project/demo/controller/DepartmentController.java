package com.project.demo.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.demo.entity.Department;
import com.project.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/department")
	public List<Department> getAllDepartments(){
		return service.getDepartments();
	}
	
	@GetMapping("department/id/{id}")
	public Department getDepartmentById(@PathVariable int id){
		return service.getDepartmentById(id);
	}
	
	@GetMapping("department/name/{name}")
	public Department getDeaprtmentByName(@PathVariable String name) {
		return service.getDepartmentByName(name);
	}
	
	@PostMapping("/department")
	public void addDepartment(@RequestBody Department dep){
		service.saveDepartment(dep);
	}
	
	@PutMapping("department/{id}")
	public void updateDepartment(@PathVariable int id, @RequestBody Department dep) {
		service.updateDepartment(id, dep);
	}
	
	@Transactional
	@DeleteMapping("department/{id}")
	public void deleteDepartment(@PathVariable int id) {
		service.removeDepartment(id);
	}
}

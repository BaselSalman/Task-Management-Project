package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.entity.Department;
import com.project.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public void saveDepartment(Department deparment) {
		repository.save(deparment);
	}

	public List<Department> getDepartments() {
		return repository.findAll();
	}

	public Department getDepartmentById(int id) {
		return repository.findById(id).orElse(null);
	}

	public void updateDepartment(int id, Department dep) {
		Department department = getDepartmentById(id);
		if (department != null) {
			department.setName(dep.getName());
			department.setLocation(dep.getLocation());
			repository.save(department);
		}
	}

	public void removeDepartment(int id) {
		repository.deleteById(id);
	}

	public Department getDepartmentByName(String name) {
		return repository.findByName(name);
	}

}

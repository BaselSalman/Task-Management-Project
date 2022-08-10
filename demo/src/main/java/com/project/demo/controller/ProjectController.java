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
import com.project.demo.entity.Project;
import com.project.demo.service.ProjectService;
import pojos.ProjectRequest;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projService;
	
	@GetMapping("/project")
	public List<Project> getAllProjects() {
		return projService.getProjects();
	}

	@GetMapping("/project/{id}")
	public Project getProjectById(@PathVariable int id) {
		return projService.getProjectById(id);
	}

	@PostMapping("/project")
	public void addProject(@RequestBody ProjectRequest project) {
		projService.saveProject(project);
	}

	@PutMapping("/project{id}")
	public void updateProject(@PathVariable int id, @RequestBody Project project) {
		projService.updateProject(id, project);
	}

	@DeleteMapping("/project/{id}")
	public void deleteProject(@PathVariable int id) {
		projService.removeProject(id);
	}
}

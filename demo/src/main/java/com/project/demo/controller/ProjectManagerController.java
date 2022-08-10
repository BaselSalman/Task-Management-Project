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
import com.project.demo.entity.ProjectManager;
import com.project.demo.service.ProjectManagerService;
import pojos.ProjManagerRequest;

@RestController
public class ProjectManagerController {
	@Autowired
	private ProjectManagerService mngrService;
	
	@GetMapping("/projectManager")
	public List<ProjectManager> getProjectManagers() {
		return mngrService.getProjectManagers();
	}

	@GetMapping("/projectManager/{id}")
	public ProjectManager getPrpjectManagerById(@PathVariable int id) {
		return mngrService.getProjectManagerById(id);
	}

	/*@GetMapping("/employeeEmail/{email}")
	public Employee getEmployeeByEmail(@PathVariable String email) {
		return service.getEmployeeByEmail(email);
	}*/

	@PostMapping("/projectManager")
	public void addProjectManager(@RequestBody ProjManagerRequest projectManager) {
		mngrService.saveProjectManager(projectManager);
	}

	/*@PostMapping("/projectManager/depId")
	public void addprojectManagerByDepartmentId(@RequestBody EmpReqByDepId projectManager) {
		mngrService.saveEmployeeByDepId(projectManager);
	}*/

	@PutMapping("/projectManager{id}")
	public void updateProjectManager(@PathVariable int id, @RequestBody ProjectManager projectManager) {
		mngrService.updateEmployee(id, projectManager);
	}

	@DeleteMapping("/deleteProjectManager/{id}")
	public void deleteProjectManager(@PathVariable int id) {
		mngrService.removeProjectManager(id);
	}
}

package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Department;
import com.project.demo.entity.ProjectManager;
import com.project.demo.entity.Qualification;
import com.project.demo.repository.DepartmentRepository;
import com.project.demo.repository.ProjectManagerRepository;
import com.project.demo.repository.ProjectRepository;
import com.project.demo.repository.QualificationRepository;

import pojos.ProjManagerRequest;

@Service
public class ProjectManagerService {

	@Autowired
	ProjectManagerRepository mngrRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	QualificationRepository qualificationRepository;
	@Autowired
	ProjectRepository projectRepository;

	public List<ProjectManager> getProjectManagers() {
		List<ProjectManager> projManagers = mngrRepository.findAll();
		for (ProjectManager mngr : projManagers) {
			mngr.setNumOfProjectsResponsibleFor(projectRepository.findByProjectManager(mngr).size());
		}
		return projManagers;
	}

	public ProjectManager getProjectManagerById(int id) {
		return mngrRepository.findById(id).orElse(null);
	}

	public void saveProjectManager(ProjManagerRequest projectManager) {
		ProjectManager projMngr = new ProjectManager();
		projMngr.setId(projectManager.getId());
		projMngr.setFirstName(projectManager.getFirstName());
		projMngr.setLastName(projectManager.getLastName());
		projMngr.setDob(projectManager.getDob());
		projMngr.setAddress(projectManager.getAddress());
		projMngr.setPhoneNumber(projectManager.getPhoneNumber());
		projMngr.setEmail(projectManager.getEmail());
		projMngr.setPosition(projectManager.getPosition());
		projMngr.setSalary(projectManager.getSalary());
		projMngr.setWorkingYears(projectManager.getWorkingYears());
		Department dep = departmentRepository.findById(projectManager.getDep_id()).get();
		projMngr.setDepartment(dep);
		Qualification qual = qualificationRepository.findByDescription(projectManager.getQual_desc());
		projMngr.getQualifications().add(qual);
		mngrRepository.save(projMngr);
	}

	public void updateEmployee(int id, ProjectManager newProjectManager) {
		ProjectManager projectManager = getProjectManagerById(id);
		if (projectManager != null) {
			if (newProjectManager.getFirstName() != null) {
				projectManager.setFirstName(newProjectManager.getFirstName());
			}
			if (newProjectManager.getLastName() != null) {
				projectManager.setLastName(newProjectManager.getLastName());
			}
			if (newProjectManager.getAddress() != null) {
				projectManager.setAddress(newProjectManager.getAddress());
			}
			if (newProjectManager.getDob() != null) {
				projectManager.setDob(newProjectManager.getDob());
			}
			if (newProjectManager.getEmail() != null) {
				projectManager.setEmail(newProjectManager.getEmail());
			}
			if (newProjectManager.getPhoneNumber() != 0) {
				projectManager.setPhoneNumber(newProjectManager.getPhoneNumber());
			}
			if (newProjectManager.getPosition() != null) {
				projectManager.setPosition(newProjectManager.getPosition());
			}
			if (newProjectManager.getSalary() != 0) {
				projectManager.setSalary(newProjectManager.getSalary());
			}
			if (newProjectManager.getDepartment() != null) {
				projectManager.setDepartment(newProjectManager.getDepartment());
			}
			if (newProjectManager.getWorkingYears() > 3) {
				projectManager.setWorkingYears(newProjectManager.getWorkingYears());
			}

			mngrRepository.save(projectManager);
		}
	}

	public void removeProjectManager(int id) {
		mngrRepository.deleteById(id);
	}

}

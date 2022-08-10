package com.project.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Project;
import com.project.demo.entity.Status;
import com.project.demo.entity.Task;
import com.project.demo.repository.ProjectManagerRepository;
import com.project.demo.repository.ProjectRepository;
import com.project.demo.repository.StatusRepository;
import com.project.demo.repository.TaskRepository;

import pojos.ProjectRequest;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projRepository;
	@Autowired
	private ProjectManagerRepository managerRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private TaskRepository taskRepository;

	public List<Project> getProjects() {
		return projRepository.findAll();
	}

	public Project getProjectById(int id) {
		return projRepository.findById(id).get();
	}

	public void saveProject(ProjectRequest proj) {
		Project project = new Project();
		project.setName(proj.getName());
		project.setDescription(proj.getDescription());
		project.setAssignedDate(proj.getAssignedDate());
		project.setDeadlineDate(proj.getDeadlineDate());
		project.setProjectManager(managerRepository.findById(proj.getProjectManagerId()).orElse(null));
		// initialize new project status to new
		project.setStatus(statusRepository.findByDesc("new"));
		if (project.getProjectManager() != null) {
			projRepository.save(project);
		}
	}

	public void updateProject(int id, Project newProject) {
		Project project = projRepository.findById(id).orElse(null);
		if (project != null) {
			if (newProject.getDescription() != null) {
				project.setDescription(newProject.getDescription());
			}
			if (newProject.getName() != null) {
				project.setName(newProject.getName());
			}
			if (newProject.getAssignedDate() != null) {
				project.setAssignedDate(newProject.getAssignedDate());
			}
			if (newProject.getDeadlineDate() != null) {
				project.setDeadlineDate(newProject.getDeadlineDate());
			}
			if (newProject.getStatus() != null) {
				project.setStatus(newProject.getStatus());
			}
		}
	}

	public void removeProject(int id) {
		projRepository.deleteById(id);
	}

	public void changeProjectStatus(Project project) {
		boolean equalTasksStatus = true;
		List<Task> tasks = taskRepository.findByProject(project);
		List<String> statusList = tasks
				.stream()
				.map(t -> t.getStatus().getDesc())
				.collect(Collectors.toList());
		for (int i = 0; i < statusList.size() - 1; i++) {
			if (!statusList.get(i).equals(statusList.get(i + 1))) {
				equalTasksStatus = false;
				break;
			}
		}
		if (equalTasksStatus) {
			project.setStatus(statusRepository.findByDesc(statusList.get(0)));
			projRepository.save(project);
		}
	}

}

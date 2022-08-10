package com.project.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Employee;
import com.project.demo.entity.Qualification;
import com.project.demo.entity.Status;
import com.project.demo.entity.Task;
import com.project.demo.repository.EmployeeRepository;
import com.project.demo.repository.ProjectRepository;
import com.project.demo.repository.QualificationRepository;
import com.project.demo.repository.StatusRepository;
import com.project.demo.repository.TaskRepository;
import pojos.ParentTaskRequest;
import pojos.SubTaskRequest;
import pojos.TaskRequest;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private QualificationRepository qualificationRepository;
	@Autowired
	private ProjectService projectService;

	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	public Task getTaskById(int id) {
		return taskRepository.findById(id).orElse(null);
	}

	public void saveParentTask(ParentTaskRequest taskRequest) {
		Task parentTask = new Task();
		parentTask.setParentTask(null);
		for (int empId : taskRequest.getEmployeesId()) {
			
			parentTask.getEmployees().add(employeeRepository.findById(empId).get());
		}
		saveTask(taskRequest, parentTask);
		if (parentTask.getProject() != null && parentTask.getEmployees() != null) {
			taskRepository.save(parentTask);
		}
	}

	public void saveSubTask(int parentId, SubTaskRequest taskRequest) {
		Task subTask = new Task();
		subTask.setParentTask(taskRepository.findById(parentId).get());
		saveTask(taskRequest, subTask);
		
		Employee emp = employeeRepository.findById(taskRequest.getEmployeeId()).get();
		List<Qualification> commonQuals = new ArrayList<Qualification>(emp.getQualifications());
		List<Qualification> taskQuals = new ArrayList<>();
		for(String qualDesc: taskRequest.getQualifications()) {
			taskQuals.add(qualificationRepository.findByDescription(qualDesc));
		}
		commonQuals.retainAll(taskQuals);
		if(new HashSet<>(commonQuals).equals(new HashSet<>(taskQuals))) {
			subTask.getEmployees().add(emp);
		} else {
			System.out.println("Employee is not capable for this task");
		}

		if (subTask.getParentTask() != null && subTask.getProject() != null && !subTask.getEmployees().isEmpty()) {
			taskRepository.save(subTask);
		}
	}

	public Task saveTask(TaskRequest taskRequest, Task task) {
		task.setName(taskRequest.getName());
		task.setDescription(taskRequest.getDescription());
		task.setAssignedDate(taskRequest.getAssignedDate());
		task.setDeadlineDate(taskRequest.getDeadlineDate());

		for (String qual_desc : taskRequest.getQualifications()) {
			Qualification qual = qualificationRepository.findByDescription(qual_desc);
			task.getQualifications().add(qual);
		}
		task.setProject(projectRepository.findById(taskRequest.getProjectId()).get());
		// initialize new task status to new
		task.setStatus(statusRepository.findByDesc("new"));
		return task;
	}

	public void updateTask(int id, Task task) {
		// TODO Auto-generated method stub

	}

	public void removeTask(int id) {
		taskRepository.deleteById(id);
	}

	public List<Task> getParentTasks() {
		List<Task> allTasks = getTasks();
		return allTasks
				.stream()
				.filter(t -> t.getParentTask() == null)
				.collect(Collectors.toList());
	}

	public List<Task> getSubTasks() {
		List<Task> allTasks = getTasks();
		return allTasks
				.stream()
				.filter(t -> t.getParentTask() != null)
				.collect(Collectors.toList());
	}
	
	public void changeTaskStatus(int taskId, String statusDesc) {
		Task task = taskRepository.findById(taskId).orElse(null);
		if(task != null) {
			if(task.getParentTask() == null) {
				changeParentTaskStatus(task);
			} else {
				changeSubTaskStatus(task, statusDesc);
			}
		}
	}
	
	public void changeSubTaskStatus(Task task, String statusDesc) {
		Status status = statusRepository.findByDesc(statusDesc);
		if(status != null) {
			System.out.println(status.getDesc());
			task.setStatus(status);
			taskRepository.save(task);
			changeParentTaskStatus(task.getParentTask());
		}
	}
	
	public void changeParentTaskStatus(Task task) {
		Set<Task> subTasks = task.getSubTasks();
		boolean equalTasksStatus = true;
		//List<Task> tasks = taskRepository.findByProject(project);
		List<String> statusList = subTasks
				.stream()
				.map(s -> s.getStatus().getDesc())
				.collect(Collectors.toList());
		for (int i = 0; i < statusList.size() - 1; i++) {
			if (!statusList.get(i).equals(statusList.get(i + 1))) {
				equalTasksStatus = false;
				break;
			}
		}
		if (equalTasksStatus) {
			task.setStatus(statusRepository.findByDesc(statusList.get(0)));
			taskRepository.save(task);
			projectService.changeProjectStatus(task.getProject());
		}
	}

}

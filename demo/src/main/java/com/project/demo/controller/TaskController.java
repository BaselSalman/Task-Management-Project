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
import com.project.demo.entity.Task;
import com.project.demo.service.TaskService;
import pojos.ParentTaskRequest;
import pojos.SubTaskRequest;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task")
	public List<Task> getAllTasks() {
		return taskService.getTasks();
	}
	
	@GetMapping("/task/parent")
	public List<Task> getParentTasks() {
		return taskService.getParentTasks();
	}
	
	@GetMapping("/task/sub")
	public List<Task> getSubTasks() {
		return taskService.getSubTasks();
	}

	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable int id) {
		return taskService.getTaskById(id);
	}

	@PostMapping("/task")
	public void addParentTask(@RequestBody ParentTaskRequest taskRequest) {
		taskService.saveParentTask(taskRequest);
	}
	
	@PostMapping("/task/sub/{parentId}")
	public void addSubTask(@PathVariable int parentId, @RequestBody SubTaskRequest taskRequest) {
		taskService.saveSubTask(parentId, taskRequest);
	}

	@PutMapping("/task/{id}")
	public void updateTask(@PathVariable int id, @RequestBody Task task) {
		taskService.updateTask(id, task);
	}

	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable int id) {
		taskService.removeTask(id);
	}
	
	@PostMapping("/task/status/{taskId}")
	public void changeTaskStatus(@PathVariable int taskId, @RequestBody String statusDesc) {
		taskService.changeTaskStatus(taskId, statusDesc);
	}
}

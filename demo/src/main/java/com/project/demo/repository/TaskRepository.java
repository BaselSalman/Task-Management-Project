package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entity.Project;
import com.project.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	List<Task> findByProject(Project project);
}

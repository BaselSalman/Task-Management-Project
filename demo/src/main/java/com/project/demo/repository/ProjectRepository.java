package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entity.Project;
import com.project.demo.entity.ProjectManager;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	List<Project> findByProjectManager(ProjectManager projManager);
}

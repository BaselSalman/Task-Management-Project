package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entity.ProjectManager;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Integer>{
}

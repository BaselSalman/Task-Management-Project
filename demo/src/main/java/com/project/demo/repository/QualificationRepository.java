package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entity.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Integer>{
	Qualification findByDescription(String desc);
	void deleteByDescription(String desc);
}

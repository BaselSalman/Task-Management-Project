package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{
	Status findByDesc(String desc);
	void deleteByDesc(String desc);
}

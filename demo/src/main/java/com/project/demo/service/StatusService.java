package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Status;
import com.project.demo.repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository statusRepository;

	public void save(Status status) {
		statusRepository.save(status);
	}

	public List<Status> getStatusValues() {
		return statusRepository.findAll();
	}

	public void deleteStatus(String desc) {
		statusRepository.deleteByDesc(desc);
	}
}

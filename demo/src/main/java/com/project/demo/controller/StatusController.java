package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entity.Status;
import com.project.demo.service.StatusService;

@RestController
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@PostMapping("/status")
	public void addStatus(@RequestBody Status status) {
		statusService.save(status);
	}
	
	@GetMapping("/status")
	public List<Status> getStatusValues(){
		return statusService.getStatusValues();
	}
	
	@DeleteMapping("/status/{desc}")
	public void deleteStatus(@PathVariable String desc) {
		statusService.deleteStatus(desc);
	}
}

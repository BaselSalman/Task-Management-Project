package com.project.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.demo.entity.Qualification;
import com.project.demo.service.QualificationService;

@RestController
public class QualificationController {
	
	@Autowired
	QualificationService qualificationService;
	
	@GetMapping("/qual")
	public List<Qualification> getAllQuals(){
		return qualificationService.getQuals();
	}

	@GetMapping("/qual/{desc}")
	public Qualification getQualByDesc(@PathVariable String desc) {
		return qualificationService.getQualByDesc(desc);
	}

	@PostMapping("/qual")
	public void addQual(@RequestBody Qualification qual) {
		qualificationService.saveQual(qual);
	}

	@PutMapping("/qual/{desc}")
	public void updateQual(@PathVariable String desc, @RequestBody Qualification qual) {
		qualificationService.updateQual(desc, qual);
	}

	@Transactional
	@DeleteMapping("/qual/{desc}")
	public void deleteQual(@PathVariable String desc) {
		qualificationService.removeQual(desc);
	}
}

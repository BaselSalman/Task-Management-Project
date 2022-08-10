package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Qualification;
import com.project.demo.repository.QualificationRepository;

@Service
public class QualificationService {
	
	@Autowired
	QualificationRepository qualificationRepository;

	public List<Qualification> getQuals() {
		return qualificationRepository.findAll();
	}

	public Qualification getQualByDesc(String desc) {
		return qualificationRepository.findByDescription(desc);
	}

	public void saveQual(Qualification qual) {
		qualificationRepository.save(qual);
	}

	public void updateQual(String desc, Qualification qual) {
		// TODO Auto-generated method stub
		
	}

	public void removeQual(String desc) {
		qualificationRepository.deleteByDescription(desc);
	}
}

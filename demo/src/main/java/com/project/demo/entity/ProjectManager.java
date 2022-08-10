package com.project.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ProjectManager")
@Table(name = "projectManager")
public class ProjectManager extends Employee {
	@Column(name = "working_years", nullable = false)
	private int workingYears;

	@JsonIgnore
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "projectManager")
	private List<Project> projectsResponsibleFor = new ArrayList<>();

	@Transient
	private int numOfProjectsResponsibleFor;

	public ProjectManager() {
	}

	public ProjectManager(int id, String firstName, String lastName, LocalDate dob, String address, int phoneNumber,
			String email, String position, float salary, Department department, Set<Qualification> qualifications,
			int workingYears, List<Project> projectsResponsibleFor) {
		super(id, firstName, lastName, dob, address, phoneNumber, email, position, salary, department, qualifications);
		this.workingYears = workingYears;
		this.projectsResponsibleFor = projectsResponsibleFor;
	}

	public int getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}

	public List<Project> getProjectsResponsibleFor() {
		return projectsResponsibleFor;
	}

	public void setProjectsResponsibleFor(List<Project> projectsResponsibleFor) {
		this.projectsResponsibleFor = projectsResponsibleFor;
	}

	public int getNumOfProjectsResponsibleFor() {
		return numOfProjectsResponsibleFor;
	}

	public void setNumOfProjectsResponsibleFor(int numOfProjectsResponsibleFor) {
		this.numOfProjectsResponsibleFor = numOfProjectsResponsibleFor;
	}

}

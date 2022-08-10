package com.project.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id", updatable = false, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(name = "assigned_date", nullable = false, columnDefinition = "DATE")
	private LocalDate assignedDate;

	@Column(name = "deadline_date", nullable = false, columnDefinition = "DATE")
	private LocalDate deadlineDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "proj_status")
	private Status status;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "proj_mngr_id")
	private ProjectManager projectManager;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<Task> tasks = new ArrayList<>();

	public Project() {
	}

	public Project(int id, String name, String description, LocalDate assignedDate, LocalDate deadlineDate, Status status,
			ProjectManager projectManager, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.deadlineDate = deadlineDate;
		this.status = status;
		this.projectManager = projectManager;
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDate getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDate deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}

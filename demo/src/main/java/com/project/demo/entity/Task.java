package com.project.demo.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Task")
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id", updatable = false, nullable = false)
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
	@JoinColumn(name = "task_status")
	private Status status;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToMany()
	@JoinTable(name = "employee_task",
			joinColumns = @JoinColumn(name = "task_id"),
			inverseJoinColumns = @JoinColumn(name = "emp_id"))
	private Set<Employee> employees = new HashSet<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "task_qual",
			joinColumns = @JoinColumn(name = "task_id"),
			inverseJoinColumns = @JoinColumn(name = "qual_id"))
	private Set<Qualification> qualifications = new HashSet<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parentTask")
	private Set<Task> subTasks = new HashSet<>();

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
	private Task parentTask;

	public Task() {
	}

	public Task(int id, String name, String description, LocalDate assignedDate, LocalDate deadlineDate, Status status,
			Project project, Set<Employee> employees, Set<Qualification> qualifications, Set<Task> subTasks, Task parentTask) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.deadlineDate = deadlineDate;
		this.status = status;
		this.project = project;
		this.employees = employees;
		this.qualifications = qualifications;
		this.subTasks = subTasks;
		this.parentTask = parentTask;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Set<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(Set<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public Task getParentTask() {
		return parentTask;
	}

	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}

}

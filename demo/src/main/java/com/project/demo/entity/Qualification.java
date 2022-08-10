package com.project.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Qualification")
@Table(name = "qualification")
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qual_id", updatable = false, nullable = false)
	private int id;

	@Column(name = "qual_desc", updatable = false, nullable = false, columnDefinition = "TEXT")
	private String description;

	@JsonIgnore
	@ManyToMany(mappedBy = "qualifications")
	private Set<Employee> employees = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "qualifications")
	private Set<Task> tasks = new HashSet<>();

	public Qualification() {
	}

	public Qualification(int id, String description, Set<Employee> employees, Set<Task> tasks) {
		super();
		this.id = id;
		this.description = description;
		this.employees = employees;
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}

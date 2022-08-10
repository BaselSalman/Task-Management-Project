package com.project.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Status")
@Table(name = "status")
public class Status {
	/*
	 * NEW, DEFINED, IN_PROGRESS, COMPLETED
	 */
	@Transient
	@JsonIgnore
	private List<String> statusList = new ArrayList<>();

	@Id
	@Column(name = "status_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String desc;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "status")
	private List<Project> projects = new ArrayList<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "status")
	private List<Task> tasks = new ArrayList<>();

	public Status() {
	}

	public Status(int id, String desc, List<Project> projects, List<Task> tasks) {
		super();
		this.id = id;
		this.desc = desc;
		this.projects = projects;
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

}

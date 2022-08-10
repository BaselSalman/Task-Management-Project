package com.project.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Employee")
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	@Id
	@Column(name = "emp_id", updatable = false, nullable = false)
	private int id;

	@Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
	private String firstName;

	@Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
	private String lastName;

	@Column(name = "dob", nullable = false, columnDefinition = "DATE")
	private LocalDate dob;

	@Column(name = "address", nullable = false, columnDefinition = "TEXT")
	private String address;

	@Column(name = "phone_number", nullable = false)
	private int phoneNumber;

	@Column(name = "email", nullable = false, columnDefinition = "TEXT")
	private String email;

	@Column(name = "position", nullable = false, columnDefinition = "TEXT")
	private String position;

	@Column(name = "salary", nullable = false, columnDefinition = "FLOAT")
	private float salary;

	@ManyToOne()
	@JoinColumn(name = "dep_id")
	private Department department;

	@ManyToMany(cascade = { CascadeType.REFRESH })
	@JoinTable(name = "emp_qual", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "qual_id"))
	private Set<Qualification> qualifications = new HashSet<>();

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
	private List<Task> tasks = new ArrayList<>();

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, LocalDate dob, String address, int phoneNumber,
			String email, String position, float salary, Department department, Set<Qualification> qualifications) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.position = position;
		this.salary = salary;
		this.department = department;
		this.qualifications = qualifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}

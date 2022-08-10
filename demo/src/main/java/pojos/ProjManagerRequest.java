package pojos;

import java.time.LocalDate;

public class ProjManagerRequest {
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String address;
	private int phoneNumber;
	private String email;
	private String position;
	private float salary;
	private int dep_id;
	private String qual_desc;
	private int workingYears;

	public ProjManagerRequest() {
	}

	public ProjManagerRequest(int id, String firstName, String lastName, LocalDate dob, String address, int phoneNumber,
			String email, String position, float salary, int dep_id, String qual_desc, int workingYears) {
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
		this.dep_id = dep_id;
		this.qual_desc = qual_desc;
		this.workingYears = workingYears;
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

	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	public String getQual_desc() {
		return qual_desc;
	}

	public void setQual_desc(String qual_desc) {
		this.qual_desc = qual_desc;
	}

	public int getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}

}

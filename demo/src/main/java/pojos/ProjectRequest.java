package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.project.demo.entity.Qualification;

public class ProjectRequest {
	private String name;
	private String description;
	private LocalDate assignedDate;
	private LocalDate deadlineDate;
	private int projectManagerId;
	private List<Qualification> qualifications = new ArrayList<>();

	public ProjectRequest() {
	}

	public ProjectRequest(String name, String description, LocalDate assignedDate, LocalDate deadlineDate,
			int projectManagerId, List<Qualification> qualifications) {
		super();
		this.name = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.deadlineDate = deadlineDate;
		this.projectManagerId = projectManagerId;
		this.qualifications = qualifications;
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

	public int getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(int projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

}

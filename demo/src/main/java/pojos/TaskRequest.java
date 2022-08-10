package pojos;

import java.time.LocalDate;
import java.util.List;

public class TaskRequest {
	private String name;
	private String description;
	private LocalDate assignedDate;
	private LocalDate deadlineDate;
	private int projectId;
	private List<String> qualifications;

	public TaskRequest() {
	}

	public TaskRequest(String name, String description, LocalDate assignedDate, LocalDate deadlineDate, int projectId,
			List<String> qualifications) {
		super();
		this.name = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.deadlineDate = deadlineDate;
		this.projectId = projectId;
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public List<String> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}

}

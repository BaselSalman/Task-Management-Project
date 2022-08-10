package pojos;

import java.time.LocalDate;
import java.util.List;

public class SubTaskRequest extends TaskRequest {
	private int employeeId;

	public SubTaskRequest() {
		super();
	}

	public SubTaskRequest(String name, String description, LocalDate assignedDate, LocalDate deadlineDate,
			int projectId, List<String> qualifications, int employeeId) {
		super(name, description, assignedDate, deadlineDate, projectId, qualifications);
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}

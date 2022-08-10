package pojos;

import java.time.LocalDate;
import java.util.List;

public class ParentTaskRequest extends TaskRequest {
	private List<Integer> employeesId;

	public ParentTaskRequest() {
		super();
	}

	public ParentTaskRequest(String name, String description, LocalDate assignedDate, LocalDate deadlineDate,
			int projectId, List<String> qualifications, List<Integer> employeesId) {
		super(name, description, assignedDate, deadlineDate, projectId, qualifications);
		this.employeesId = employeesId;
	}

	public List<Integer> getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(List<Integer> employeesId) {
		this.employeesId = employeesId;
	}

}

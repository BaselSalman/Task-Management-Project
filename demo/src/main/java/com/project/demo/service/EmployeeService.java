package com.project.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.entity.Department;
import com.project.demo.entity.Employee;
import com.project.demo.entity.ProjectManager;
import com.project.demo.entity.Qualification;
import com.project.demo.repository.DepartmentRepository;
import com.project.demo.repository.EmployeeRepository;
import com.project.demo.repository.ProjectRepository;
import com.project.demo.repository.QualificationRepository;

import pojos.EmpReqByDepId;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private QualificationRepository qualificationRepository;
	@Autowired
	private ProjectRepository projectRepository;

	/*public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		saveEmployeeInDepartment(employee);
	}*/
	
	public void saveEmployee(EmpReqByDepId emp) {
		Employee employee = new Employee();
		employee.setId(emp.getId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setAddress(emp.getAddress());
		employee.setDob(emp.getDob());
		employee.setEmail(emp.getEmail());
		employee.setPhoneNumber(emp.getPhoneNumber());
		employee.setPosition(emp.getPosition());
		employee.setSalary(emp.getSalary());
		Department dep = departmentRepository.findById(emp.getDep_id()).get();
		employee.setDepartment(dep);
		
		for(String qual_desc : emp.getQualifications()) {
			Qualification qual = qualificationRepository.findByDescription(qual_desc);
			employee.getQualifications().add(qual);
		}
		employeeRepository.save(employee);
		saveEmployeeInDepartment(employee);
	}
	
	private void saveEmployeeInDepartment(Employee employee) {
		Department department = departmentRepository.findById(employee.getDepartment().getId()).get();
		department.getEmployees().add(employee);
		departmentRepository.save(department);
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		for(Employee emp : employees) {
			if(emp instanceof ProjectManager) {
				((ProjectManager)emp).setNumOfProjectsResponsibleFor(
						(projectRepository.findByProjectManager((ProjectManager)emp).size()));
			}
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public void updateEmployee(int id, EmpReqByDepId emp) {
		Employee employee = getEmployeeById(id);
		Department department = departmentRepository.findById(emp.getDep_id()).orElse(null);
		if (employee != null) {
			if (emp.getFirstName() != null) {
				employee.setFirstName(emp.getFirstName());
			}
			if (emp.getLastName() != null) {
				employee.setLastName(emp.getLastName());
			}
			if (emp.getAddress() != null) {
				employee.setAddress(emp.getAddress());
			}
			if (emp.getDob() != null) {
				employee.setDob(emp.getDob());
			}
			if (emp.getEmail() != null) {
				employee.setEmail(emp.getEmail());
			}
			if (emp.getPhoneNumber() != 0) {
				employee.setPhoneNumber(emp.getPhoneNumber());
			}
			if (emp.getPosition() != null) {
				employee.setPosition(emp.getPosition());
			}
			if (emp.getSalary() > 0) {
				employee.setSalary(emp.getSalary());
			}
			if (department != null) {
				employee.setDepartment(department);
			}
			for(String qualDisc : emp.getQualifications()) {
				Qualification qual = qualificationRepository.findByDescription(qualDisc);
				if(qual != null) {
					employee.getQualifications().add(qual);
				}
			}
			employeeRepository.save(employee);
		}
	}

	public void removeEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

}

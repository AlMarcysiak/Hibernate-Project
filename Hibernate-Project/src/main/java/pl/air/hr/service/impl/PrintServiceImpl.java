package pl.air.hr.service.impl;

import java.util.List;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.JobGrade;
import pl.air.hr.model.Position;
import pl.air.hr.model.Project;
import pl.air.hr.service.PrintService;

public class PrintServiceImpl implements PrintService {
	
	/* department */
	@Override
	public void printDepartment(Department one) {
		System.out.format("id = %-3d | name = %-20s | location = %-20s \n", 
				one.getId(), one.getName(), one.getLocation()
		);
	}
	
	@Override
	public void printDepartments(List<Department> many) {
		for (Department one : many) {
			printDepartment(one);
		}
	}
	
	
	/* position */
	@Override
	public void printPosition(Position one) {
		System.out.format("id = %-3d | name = %-20s \n", 
				one.getId(), one.getName());
	}
	
	@Override
	public void printPositions(List<Position> many) {
		for (Position one : many) {
			printPosition(one);
		}
	}
	
	
	/* job grade */
	@Override
	public void printJobGrade(JobGrade one) {
		System.out.format("id = %-3d | name = %-20s | min = %9.2f | max = %9.2f \n", 
				one.getId(), one.getName(), one.getMinSalary(), one.getMaxSalary());
	}
	
	@Override
	public void printJobGrades(List<JobGrade> many) {
		for (JobGrade one : many) {
			printJobGrade(one);
		}
	}

	
	/* employee */
	@Override
	public void printEmployee(Employee one) {
		System.out.format("id = %-3d | %-30s | salary = %8.2f | hired = %tF | %-20s | %-20s | %4s \n", 
				one.getId(), one.getFirstName() + " " + one.getLastName(), 
				one.getSalary(), one.getHireDate(), 
				one.getDepartment().getName(), 
				one.getPosition().getName(),
				one.getJobGrade().getName()
		);
	}
	
	@Override
	public void printEmployees(List<Employee> many) {
		for (Employee one : many) {
			printEmployee(one);
		}
	}
	
	
	/* project */
	@Override
	public void printProject(Project one) {
		System.out.format("id = %-3d | name = %-20s | start = %tF | end = %tF \n", 
				one.getId(), one.getName(), one.getStartDate(), one.getEndDate());
		
		System.out.println("Participants:");
		for (Employee e : one.getParticipants()) {
			System.out.format("   * id = %-3d | %-30s | %-20s \n", 
					e.getId(), 
					e.getFirstName() + " " + e.getLastName(), 
					e.getDepartment().getName() 
			);
		}
		
		System.out.println();
	}
	
	@Override
	public void printProjects(List<Project> many) {
		for (Project one : many) {
			printProject(one);
		}
	}
	
	
	/* others */
	@Override
	public void printEmptyLine() {
		System.out.println();
	}
	
	@Override
	public void printEmptyLines(int count) {
		for(int i = 0; i < count; i++) {
			printEmptyLine();
		}
	}

}

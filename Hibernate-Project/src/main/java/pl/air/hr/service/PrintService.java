package pl.air.hr.service;

import java.util.List;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.JobGrade;
import pl.air.hr.model.Position;
import pl.air.hr.model.Project;

public interface PrintService {

	/* department */
	void printDepartment(Department one);
	void printDepartments(List<Department> many);

	/* position */
	void printPosition(Position one);
	void printPositions(List<Position> many);

	/* job grade */
	void printJobGrade(JobGrade one);
	void printJobGrades(List<JobGrade> many);

	/* employee */
	void printEmployee(Employee one);
	void printEmployees(List<Employee> many);

	/* project */
	void printProject(Project one);
	void printProjects(List<Project> many);

	/* others */
	void printEmptyLine();
	void printEmptyLines(int count);

}

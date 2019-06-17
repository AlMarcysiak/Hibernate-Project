package pl.air.hr.dao;

import java.util.List;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;

public interface EmployeeDAO extends DAO<Employee> {
	
	public Employee findOneByName(String firstName, String lastName);

	public List<Employee> findAllByDepartment(Department department);
	public List<Employee> findAllByDepartment(String depName);
	
}

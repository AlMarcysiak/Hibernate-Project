package pl.air.hr.dao;

import pl.air.hr.model.Department;

public interface DepartmentDAO extends DAO<Department> {
	
	public Department findOneByName(String name);

}

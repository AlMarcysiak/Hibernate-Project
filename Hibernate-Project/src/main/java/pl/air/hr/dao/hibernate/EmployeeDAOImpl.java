package pl.air.hr.dao.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.query.Query;

import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;

public class EmployeeDAOImpl extends DAOImpl<Employee> implements EmployeeDAO {

	
	public Employee findOneByName(String firstName, String lastName) {
		Query<Employee> query = 
				getSession().createQuery(
						"FROM Employee " +
						"WHERE firstName = :firstName AND lastName = :lastName ", 
						Employee.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		
		Employee one;
		try {
			one = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			one = null;
		}
		
		return one;		
	}

	
	public List<Employee> findAllByDepartment(Department department) {
		List<Employee> all = 
			getSession().createQuery(
						"FROM Employee " +
						"WHERE department = :department ", 
						Employee.class)
			.setParameter("department", department)
			.getResultList();
		return all;
	}
	
	public List<Employee> findAllByDepartment(String depName) {
		List<Employee> all = 
			getSession().createQuery(
						"FROM Employee " +
						"WHERE department.name = :depName ", 
						Employee.class)
			.setParameter("depName", depName)
			.getResultList();
		return all;
	}
	
}

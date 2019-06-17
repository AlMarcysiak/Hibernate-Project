package pl.air.hr.dao.hibernate;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.query.Query;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.model.Department;

public class DepartmentDAOImpl extends DAOImpl<Department> implements DepartmentDAO {

	public Department findOneByName(String name) {
		Query<Department> query = 
				getSession().createQuery(
						"FROM Department WHERE name = :name" , 
						Department.class);
		query.setParameter("name", name);
		
		Department one = null;
		try {
			one = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			one = null;
		}
		
		return one;
	}

}

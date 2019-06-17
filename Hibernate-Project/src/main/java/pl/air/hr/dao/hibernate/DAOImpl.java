package pl.air.hr.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import pl.air.hr.dao.DAO;
import pl.air.hr.service.HibernateService;

public class DAOImpl<T> implements DAO<T> {

	protected Class<T> clazz;
	protected String clazzName;

	
	@SuppressWarnings("unchecked")
	protected DAOImpl() {
		Type tSuperclass = this.getClass().getGenericSuperclass();
		Type tType = ((ParameterizedType)tSuperclass).getActualTypeArguments()[0];
		this.clazz = (Class<T>) tType;
		this.clazzName = clazz.getSimpleName();
	}	

	
	protected Session getSession() {
		return HibernateService.getSession();
	}

	

	@Override
	public T findOne(Integer id) {
		T one = getSession().get(clazz, id);
		return one;
	}

	@Override
	public List<T> findAll() {
		Query<T> query = getSession().createQuery("FROM " + clazzName, clazz);
		List<T> all = query.getResultList();
		return all;
	}
	
	
	/* create */
	public void persist(T one) {
		getSession().persist(one);
	}
	
	
	/* delete */
	public void delete(T one) {
		getSession().delete(one);
	}
	
	public void delete(Integer id) {
		T one = findOne(id);
		delete(one);
	}
	
	
	/* update */
	public void update(T one) {
		getSession().update(one);
	}
	
}

package pl.air.hr.dao;

import java.util.List;

public interface DAO<T> {
	
	/* read */
	public T findOne(Integer id);
	public List<T> findAll();
	
	/* create */
	public void persist(T one);
	
	
	/* delete */
	public void delete(T one);
	public void delete(Integer id);
	
	
	/* update */
	public void update(T one);

}

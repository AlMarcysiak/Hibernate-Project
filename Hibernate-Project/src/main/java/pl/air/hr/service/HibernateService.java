package pl.air.hr.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateService {
	
	private static final SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static void startup() {		
	}
	
	public static void shutdown() {
		sessionFactory.close();
	}

	
	/* session */
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void closeSession() {
		getSession().close();
	}
	
	
	/* transaction */
	public static Transaction beginTransaction() {
		return getSession().beginTransaction();		
	}
	
	public static Transaction getTransaction() {
		return getSession().getTransaction();
	}
	
	public static void commitTransaction() {
		getTransaction().commit();
	}
}

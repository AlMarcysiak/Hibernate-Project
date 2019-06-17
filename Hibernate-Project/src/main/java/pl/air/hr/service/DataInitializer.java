package pl.air.hr.service;

import java.time.LocalDate;

import pl.air.hr.dao.hibernate.DepartmentDAOImpl;
import pl.air.hr.dao.hibernate.EmployeeDAOImpl;
import pl.air.hr.dao.hibernate.JobGradeDAOImpl;
import pl.air.hr.dao.hibernate.ProjectDAOImpl;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.JobGrade;
import pl.air.hr.model.Position;
import pl.air.hr.model.Project;

public class DataInitializer {
	
	public void insertData() {
		HibernateService.beginTransaction();
		
		// create entities (data model objects)
		Department marketing = createDepartment("Marketing", "Pokój 2.3");
		Department sales = createDepartment("Sprzedaż", "Budynek A4");
		Department accounting = createDepartment("Księgowość", "Budynek A3, II piętro");
		
		Position manager = createPosition("Kierownik");
		Position expert = createPosition("Ekspert");
		Position specialist = createPosition("Specjalista");
		
		JobGrade i = createJobGrade("I", 0, 1999);
		JobGrade ii = createJobGrade("II", 2000, 3999);
		JobGrade iii = createJobGrade("III", 4000, 6999);
		JobGrade iv = createJobGrade("IV", 7000, 19999);
		
		Employee zk = createEmployee("Zofia", "Kowalska", LocalDate.parse("2019-02-01"), 6900, marketing, manager, iii);
		Employee jn = createEmployee("Jan", "Nowak", LocalDate.parse("2009-07-15"), 3900, marketing, expert, ii);
		Employee wt = createEmployee("Wojciech", "Trzaska", LocalDate.parse("2012-10-01"), 4500, sales, expert, iii);
		Employee em = createEmployee("Ewa", "Mucha", LocalDate.parse("1999-01-01"), 7200, sales, expert, iv);
		Employee mk = createEmployee("Marek", "Kania", LocalDate.parse("2015-05-01"), 2900, sales, specialist, ii);
		
		Project p1 = createProject("Wdrożenie modułu FK", LocalDate.parse("2017-02-01"), LocalDate.parse("2017-08-31"));
		Project p2 = createProject("Opracowanie regulaminu pracy", LocalDate.parse("2017-03-01"), LocalDate.parse("2017-04-15"));
		Project p3 = createProject("Przygotowanie strategii sprzedażowej 'WIOSNA 2018'", LocalDate.parse("2017-09-01"), null);
		Project p4 = createProject("Przejęcie firmy 'NOWA NADZIEJA'", LocalDate.parse("2017-06-01"), null);
		Project p5 = createProject("Opracowanie nowej strony firmowej", LocalDate.parse("2017-04-01"), LocalDate.parse("2017-06-30"));
		
		p1.addParticipants(zk, wt, em, mk);
		p2.addParticipants(zk, jn);
		p3.addParticipants(em, mk);
		
		// instantiate DAO
		DepartmentDAOImpl depDAO = new DepartmentDAOImpl();
		JobGradeDAOImpl jgDAO = new JobGradeDAOImpl();
		EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
		ProjectDAOImpl projDAO = new ProjectDAOImpl();
		
		// persist (save) entities in the database
		depDAO.persist(accounting);
		
		jgDAO.persist(i);

		empDAO.persist(zk);
		empDAO.persist(jn);
		empDAO.persist(wt);
		empDAO.persist(em);
		empDAO.persist(mk);
		
		projDAO.persist(p1);
		projDAO.persist(p2);
		projDAO.persist(p3);
		projDAO.persist(p4);
		projDAO.persist(p5);

		HibernateService.commitTransaction();
	}
	
	
	private Department createDepartment(String name, String location) {
		Department one = new Department();
		one.setName(name);
		one.setLocation(location);
		return one;
	}
	
	private Position createPosition(String name) {
		Position one = new Position();
		one.setName(name);
		return one;
	}
	
	private JobGrade createJobGrade(String name, double minSalary, double maxSalary) {
		JobGrade one = new JobGrade();
		one.setName(name);
		one.setMinSalary(minSalary);
		one.setMaxSalary(maxSalary);
		return one;
	}
	
	private Project createProject(String name, LocalDate startDate, LocalDate endDate) {
		Project one = new Project();
		one.setName(name);
		one.setStartDate(startDate);
		one.setEndDate(endDate);
		return one;
	}
	
	private Employee createEmployee(String firstName, String lastName, LocalDate hireDate, double salary, 
			Department department, Position position, JobGrade jobGrade) {
		Employee one = new Employee();
		one.setFirstName(firstName);
		one.setLastName(lastName);
		one.setHireDate(hireDate);
		one.setSalary(salary);
		one.setDepartment(department);
		one.setPosition(position);
		one.setJobGrade(jobGrade);
		
		return one;
	}

}

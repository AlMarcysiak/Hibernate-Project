package pl.air.hr.service.menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.JobGradeDAO;
import pl.air.hr.dao.PositionDAO;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.JobGrade;
import pl.air.hr.model.Position;
import pl.air.hr.service.PrintService;

public class MenuEmployee extends BaseMenu {
	
	protected DepartmentDAO depDAO;
	protected EmployeeDAO empDAO;
	protected PositionDAO posDAO;
	protected JobGradeDAO jgDAO;
	
	public MenuEmployee(Scanner sc, PrintService printSrv, DepartmentDAO depDAO, EmployeeDAO empDAO, PositionDAO posDAO, JobGradeDAO jgDAO) {
		super(sc, printSrv);
		this.depDAO = depDAO;
		this.empDAO = empDAO;
		this.posDAO = posDAO;
		this.jgDAO = jgDAO;
	}
	
	
	/* menu option: Print one employee */
	public void oneEmployee( ) {
		beginTransaction();
		
		int id = readId();
		Employee one = empDAO.findOne(id);
		if (one != null)
			printSrv.printEmployee(one);
		else
			System.out.println("No data found!");
		
		commitTransaction();
	}
	
	
	/* menu option: Print all employees */
	public void allEmployees() {
		beginTransaction();

		List<Employee> all = empDAO.findAll();
		printSrv.printEmployees(all);
		
		commitTransaction();
	}
	
	
	/* menu option: Find employee by name */
	public void findEmployee( ) {
		beginTransaction();
		
		String firstName = readText("Enter first name");
		String lastName = readText("Enter last name");
		Employee one = empDAO.findOneByName(firstName, lastName);
		if (one != null)
			printSrv.printEmployee(one);
		else
			System.out.println("No data found!");
		
		commitTransaction();
	}
	
	
	/* menu option: Find all employees by dep id */
	public void findAllEmployeesDepId( ) {
		beginTransaction();
		
		int depId = readInt("Enter dep id");
		Department department = depDAO.findOne(depId);
		List<Employee> all = empDAO.findAllByDepartment(department);
		printSrv.printEmployees(all);
		
		commitTransaction();
	}
	
	
	/* menu option: Find all employees by dep name */
	public void findAllEmployeesDepName( ) {
		beginTransaction();
		
		String depName = readText("Enter dep name");
		List<Employee> all = empDAO.findAllByDepartment(depName);
		printSrv.printEmployees(all);
		
		commitTransaction();
	}

	
	/* menu option: Insert employee */
	public void insertEmployee() {
		beginTransaction();
		
		String firstName = readText("Enter first name");
		String lastName = readText("Enter last name");
		double salary = readDouble("Enter salary");
		
		String hireDateText = readText("Enter hire date (yyyy-mm-dd)");
		LocalDate hireDate = LocalDate.parse(hireDateText);
		
		int depId = readInt("Enter depId");
		Department department = depDAO.findOne(depId);
		
		int posId = readInt("Enter posId");
		Position position = posDAO.findOne(posId);
		
		int jgId = readInt("Enter jgId");
		JobGrade jobGrade = jgDAO.findOne(jgId);
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
		emp.setDepartment(department);
		emp.setPosition(position);
		emp.setJobGrade(jobGrade);
		
		empDAO.persist(emp);
		
		printSrv.printEmployee(emp);
		
		commitTransaction();
	}

}

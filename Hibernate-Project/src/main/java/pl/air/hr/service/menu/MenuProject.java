package pl.air.hr.service.menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.service.PrintService;

public class MenuProject extends BaseMenu {
	
	private ProjectDAO projDAO;
	private EmployeeDAO empDAO;
	
	public MenuProject(Scanner sc, PrintService printSrv, ProjectDAO projDAO, EmployeeDAO empDAO) {
		super(sc, printSrv);
		this.projDAO = projDAO;
		this.empDAO = empDAO;
	}
	
	
	/* menu option: Print one project */
	public void oneProject( ) {
		beginTransaction();
		
		int id = readId();
		Project one = projDAO.findOne(id);
		if (one != null)
			printSrv.printProject(one);
		else
			System.out.println("No data found!");
		
		commitTransaction();
	}
	
	
	/* menu option: Print all projects */
	public void allProjects() {
		beginTransaction();

		List<Project> all = projDAO.findAll();
		printSrv.printProjects(all);
		
		commitTransaction();
	}
	
	/* menu option: Insert project */
	public void insertProject() {
		beginTransaction();
		
		String name = readText("Enter project name");
		
		String startDateText = readText("Enter start date (yyyy-mm-dd)");
		LocalDate startDate = LocalDate.parse(startDateText);
		
		String endDateText = readText("Enter end date (yyyy-mm-dd)");
		LocalDate endDate = null;
		if (! endDateText.equals(""))
			endDate = LocalDate.parse(endDateText);
		
		String empIdsText = readText("Enter employee ids (comma separated)");

		Project proj = new Project();
		proj.setName(name);
		proj.setStartDate(startDate);
		proj.setEndDate(endDate);
		
		String[] empIds = empIdsText.split(",");
		for (String eId : empIds) {
			int id = Integer.parseInt(eId.trim());
			Employee employee = empDAO.findOne(id);
			proj.addParticipant(employee);
		}
		
		projDAO.persist(proj);
		
		printSrv.printEmptyLine();
		printSrv.printProject(proj);
		
		commitTransaction();
	}

}

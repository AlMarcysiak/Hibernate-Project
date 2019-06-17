package pl.air.hr.service.menu;

import java.util.List;
import java.util.Scanner;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.model.Department;
import pl.air.hr.service.PrintService;

public class MenuDepartment extends BaseMenu {

	protected DepartmentDAO depDAO;
	
	public MenuDepartment(Scanner sc, PrintService printSrv, DepartmentDAO depDAO) {
		super(sc, printSrv);
		this.depDAO = depDAO;
	}
	
	
	/* menu option: Print one department */
	public void oneDepartment( ) {
		beginTransaction();
		
		int id = readId();
		Department one = depDAO.findOne(id);
		if (one != null)
			printSrv.printDepartment(one);
		else
			System.out.println("No data found!");
		
		commitTransaction();
	}
	
	
	/* menu option: Print all departments */
	public void allDepartments() {
		beginTransaction();

		List<Department> all = depDAO.findAll();
		printSrv.printDepartments(all);
		
		commitTransaction();
	}

}

package pl.air.hr;

import java.util.Scanner;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.JobGradeDAO;
import pl.air.hr.dao.PositionDAO;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.dao.hibernate.DepartmentDAOImpl;
import pl.air.hr.dao.hibernate.EmployeeDAOImpl;
import pl.air.hr.dao.hibernate.JobGradeDAOImpl;
import pl.air.hr.dao.hibernate.PositionDAOImpl;
import pl.air.hr.dao.hibernate.ProjectDAOImpl;
import pl.air.hr.service.PrintService;
import pl.air.hr.service.impl.PrintServiceImpl;
import pl.air.hr.service.menu.MenuDepartment;
import pl.air.hr.service.menu.MenuEmployee;
import pl.air.hr.service.menu.MenuMain;
import pl.air.hr.service.menu.MenuPosition;
import pl.air.hr.service.menu.MenuProject;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintService printSrv = new PrintServiceImpl();
		
		DepartmentDAO depDAO = new DepartmentDAOImpl();
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		PositionDAO posDAO = new PositionDAOImpl();
		ProjectDAO projDAO = new ProjectDAOImpl();
		JobGradeDAO jgDAO = new JobGradeDAOImpl();
		
		MenuMain menuMain = new MenuMain(sc, printSrv);
		MenuDepartment menuDep = new MenuDepartment(sc, printSrv, depDAO);
		MenuEmployee menuEmp = new MenuEmployee(sc, printSrv, depDAO, empDAO, posDAO, jgDAO);
		MenuPosition menuPos = new MenuPosition(sc, printSrv, posDAO);
		MenuProject menuProj = new MenuProject(sc, printSrv, projDAO, empDAO);

		
		HRSystem hrSystem = new HRSystem(sc, menuMain, menuDep, menuEmp, menuPos, menuProj);
		hrSystem.run();		
	}

}

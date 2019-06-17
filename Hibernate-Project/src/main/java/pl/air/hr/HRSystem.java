package pl.air.hr;

import java.util.Scanner;

import pl.air.hr.service.DataInitializer;
import pl.air.hr.service.HibernateService;
import pl.air.hr.service.menu.MenuDepartment;
import pl.air.hr.service.menu.MenuEmployee;
import pl.air.hr.service.menu.MenuMain;
import pl.air.hr.service.menu.MenuPosition;
import pl.air.hr.service.menu.MenuProject;

public class HRSystem {
	
	private MenuMain menuMain;
	private MenuDepartment menuDep;
	private MenuEmployee menuEmp;
	private MenuPosition menuPos;
	private MenuProject menuProj;
	
	
	/* constructor */
	public HRSystem(Scanner sc, MenuMain menuMain, MenuDepartment menuDep, MenuEmployee menuEmp, MenuPosition menuPos, MenuProject menuProj) {
		this.menuMain = menuMain;
		this.menuDep = menuDep;
		this.menuEmp = menuEmp;
		this.menuPos = menuPos;
		this.menuProj = menuProj;
	}
	
	
	/* main method */
	public void run() {
		HibernateService.startup();
		HibernateService.openSession();
		
		initData();
		boolean loop = true;
		
		while (loop) {
			int option = menuMain.getMenuOption();
			switch (option) {
				case 1:
					menuDep.oneDepartment();
					break;
				case 2:
					menuDep.allDepartments();
					break;
					
				case 3:
					menuEmp.oneEmployee();
					break;
				case 4:
					menuEmp.allEmployees();
					break;

				case 5:
					menuEmp.findEmployee();
					break;
				case 6:
					menuEmp.findAllEmployeesDepId();
					break;
				case 7:
					menuEmp.findAllEmployeesDepName();
					break;
					
				case 8:
					menuEmp.insertEmployee();
					break;
					
				case 9:
					menuPos.onePosition();
					break;
				case 10:
					menuPos.allPositions();
					break;
				case 11:
					menuPos.insertPosition();
					break;
					
				case 12:
					menuProj.oneProject();
					break;
				case 13:
					menuProj.allProjects();
					break;					
				case 14:
					menuProj.insertProject();
					break;

				case 15:
					menuMain.exit();
					loop = false;
					break;
			}
		}
		
		HibernateService.closeSession();
		HibernateService.shutdown();		
	}

	
	/* initialize data */
	private void initData() {
		DataInitializer dataInit = new DataInitializer();
		dataInit.insertData();		
	}

}

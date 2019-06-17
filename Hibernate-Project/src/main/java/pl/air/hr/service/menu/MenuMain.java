package pl.air.hr.service.menu;

import java.util.Scanner;

import pl.air.hr.service.PrintService;

public class MenuMain extends BaseMenu {
	
	public MenuMain(Scanner sc, PrintService printSrv) {
		super(sc, printSrv);
	}
	
	
	/* get menu option */
	public int getMenuOption() {
		String menu = 
			"                                                                       \n" +
			"                                                                       \n" +
			"====================================================================== \n" +
			"Menu                                      \n" +
			"------------------------                  \n" +
			" 1. Print one department                  \n" +
			" 2. Print all departments                 \n" +
			"                                          \n" +
			" 3. Print one employee                    \n" +
			" 4. Print all employees                   \n" +
			"                                          \n" +
			" 5. Find employee by name                 \n" +
			" 6. Find all employees by department id   \n" +
			" 7. Find all employees by department name \n" +
			"                                          \n" +
			" 8. Insert employee                       \n" +
			"                                          \n" +
			" 9. Print one position                    \n" +
			"10. Print all positions                   \n" +			
			"11. Insert position                       \n" +
			"                                          \n" +
			"12. Print one project                     \n" +
			"13. Print all projects                    \n" +			
			"14. Insert project                        \n" +			
			"                                          \n" +
			"15. Exit                                  \n" +
			"                                          \n";		
		System.out.print(menu);
		
		int option = readInt("Select option");
		System.out.println();
		return option;
	}

	/* menu option: Exit */
	public void exit() {
		System.out.println("Thank you!");
	}
	
}

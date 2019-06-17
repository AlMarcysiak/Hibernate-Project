package pl.air.hr.service.menu;

import java.util.Scanner;

import pl.air.hr.service.HibernateService;
import pl.air.hr.service.PrintService;

public abstract class BaseMenu {
	
	protected Scanner sc;
	protected PrintService printSrv;
	
	public BaseMenu(Scanner sc, PrintService printSrv) {
		this.sc = sc;
		this.printSrv = printSrv;
	}

	
	/* transactions */
	protected void beginTransaction() {
		HibernateService.beginTransaction();
	}
	
	protected void commitTransaction() {
		HibernateService.commitTransaction();
	}

	
	/* read input */
	protected int readId() {
		int id = readInt("Enter id");
		return id;
	}
	
	protected int readInt(String prompt) {
		System.out.print(prompt + ": ");
		String input = sc.nextLine();
		int value = Integer.parseInt(input);
		return value;		
	}
	
	protected double readDouble(String prompt) {
		System.out.print(prompt + ": ");
		String input = sc.nextLine();
		double value = Double.parseDouble(input); 
		return value;		
	}
	
	protected String readText(String prompt) {
		System.out.print(prompt + ": ");
		String value = sc.nextLine();
		return value;		
	}

}

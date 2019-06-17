package pl.air.hr.service.menu;

import java.util.List;
import java.util.Scanner;

import pl.air.hr.dao.PositionDAO;
import pl.air.hr.model.Position;
import pl.air.hr.service.PrintService;

public class MenuPosition extends BaseMenu {
	
	private PositionDAO posDAO;
	
	public MenuPosition(Scanner sc, PrintService printSrv, PositionDAO posDAO) {
		super(sc, printSrv);
		this.posDAO = posDAO;
	}
	
	
	/* menu option: Print one position */
	public void onePosition( ) {
		beginTransaction();
		
		int id = readId();
		Position one = posDAO.findOne(id);
		if (one != null)
			printSrv.printPosition(one);
		else
			System.out.println("No data found!");
		
		commitTransaction();
	}
	
	
	/* menu option: Print all positions */
	public void allPositions() {
		beginTransaction();

		List<Position> all = posDAO.findAll();
		printSrv.printPositions(all);
		
		commitTransaction();
	}
	
	
	/* menu option: Insert position */
	public void insertPosition() {
		beginTransaction();
		String name = readText("Enter position name");
		
		Position one = new Position();
		one.setName(name);
		posDAO.persist(one);
		
		printSrv.printPosition(one);
		
		commitTransaction();
	}
	
}

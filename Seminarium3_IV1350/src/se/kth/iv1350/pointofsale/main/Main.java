package se.kth.iv1350.pointofsale.main;

import se.kth.iv1350.pointofsale.controller.*;
import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.view.*;

/**
 * Class that starts the application, contains the main method.
 *
 */

public class Main {
	
	/**
	 * Creates MVC objects and starts the application by calling the
	 * simulateSale method
	 * @param args
	 */
	
	public static void main(String[] args) {
		ExternalInventorySystem extInv = new ExternalInventorySystem();
		ExternalAccountingSystem extAcc = new ExternalAccountingSystem();
		
		Controller contr = new Controller(extInv,extAcc);
		
		View view = new View(contr);
		
		view.simulateSale();
	}

}

package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.*;
import se.kth.iv1350.pointofsale.integration.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Placeholder for an actual view. Starts a simulated sale instance
 *
 */

public class View {
	private Controller contr;
	
	/**
	 * Creates a new view to be used
	 * @param contr controller through which all commands pass
	 */
	
	public View(Controller contr) {
		this.contr = contr;
		contr.addObserver(new TotalRevenueView());
		contr.addObserver(new TotalRevenueFileOutput());
	}
	
	/**
	 * Starts a simulated sale using hard-coded method calls and items
	 * If the item ID is the same as the hard-coded values 13 or 123, it triggers the 
	 * invalid ID or the database offline exceptions, respectively 
	 */
	
	public void simulateSale() throws IOException {
		contr.startSale();
		System.out.println("New sale started");
		
		
		String str = "";
		double total = 0;
		FileWriter errLog = null;
		
		try {
		
		errLog = new FileWriter("src/se/kth/iv1350/pointofsale/integration/log.txt", true);
			
		str = contr.scanItem(0);
		System.out.println(str);
		str = contr.scanItem(0);
		System.out.println(str);
		str = contr.scanItem(0);
		System.out.println(str);
		str = contr.scanItem(0);
		System.out.println(str);
		str = contr.scanItem(0);
		System.out.println(str);
		for(int i = 0; i < 4; i++) {
				str = contr.scanItem(i);
				System.out.println(str);
			}
		//str = contr.scanItem(123);
		str = contr.scanItem(13);
		System.out.println(str);
		str = contr.scanItem(3);
		System.out.println(str);
		
		}catch(DatabaseNotRunningException e) {
			System.err.println("Cannot reach database");
			errLog.write("DatabaseNotRunningException: " + e.getMessage() + " \n");
			errLog.close();
		}catch(InvalidItemIDException e) {
			System.err.println("There are no items with that ID");
			errLog.write("InvalidItemIDException: " + e.getMessage() + " \n");
			errLog.close();
		}
		
		total = contr.endSale();
		System.out.println("Total cost of purchase: " + total);
		double change = 0;
		change = contr.pay(1000, "cash");
		System.out.println("Change: " + change);
		System.out.println("Sale ended");
	}
}

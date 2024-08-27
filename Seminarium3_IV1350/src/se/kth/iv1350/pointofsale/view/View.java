package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.*;
import se.kth.iv1350.pointofsale.integration.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	}
	
	/**
	 * Starts a simulated sale using hard-coded method calls and items
	 */
	
	public void simulateSale() {
		contr.startSale();
		System.out.println("New sale started");
		
		String str = "";
		double total = 0;
		
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
		str = contr.scanItem(13);
		System.out.println(str);
		str = contr.scanItem(3);
		System.out.println(str);
		
		total = contr.endSale();
		System.out.println("Total cost of purchase: " + total);
		double change = 0;
		change = contr.pay(1000, "cash");
		System.out.println("Change: " + change);
		System.out.println("Sale ended");
	}
}

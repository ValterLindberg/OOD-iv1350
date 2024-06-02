package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.*;

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
		//hard-coded stuff
		contr.scanItem(0);
		contr.scanItem(0);
		contr.scanItem(0);
		contr.scanItem(0);
		contr.scanItem(0);
		for(int i = 0; i < 4; i++) {
			contr.scanItem(i);
		}
		//hard-coded stuff
		contr.endSale();
		double change = 0;
		change = contr.pay(1000, "cash");
		System.out.println("Change: " + change);
		System.out.println("Sale ended");
	}
}

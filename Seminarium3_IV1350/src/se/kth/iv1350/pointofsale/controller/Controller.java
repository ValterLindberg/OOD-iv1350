package se.kth.iv1350.pointofsale.controller;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;



/**
 * This is the controller class of the program
 * which contains all the core methods of the application
 */

public class Controller {
	private ExternalInventorySystem extInv;
	private ExternalAccountingSystem extAcc;
	private Sale sale;
	private double costOfSale;
	
	/**
	 * Creates a controller instance, used to control the main
	 * functionalities of the program
	 * @param extInv used to access the inventory system
	 * @param extAcc used to access the accounting system
	 */
	
	public Controller(ExternalInventorySystem extInv, ExternalAccountingSystem extAcc) {
		this.extInv = extInv;
		this.extAcc = extAcc;
	}
	
	/**
	 * This method starts a new sale instance, must be called before
	 * all other methods.
	 */
	
	public void startSale() {
		this.sale = new Sale(this.extInv,this.extAcc);
	}
	
	/**
	 * Scans a given item, if item ID is invalid it moves on to the next item,
	 * if valid it adds the item to the list
	 * @param itemID item identification used to check item validity
	 */
	
	public String scanItem(int itemID) {
		
		
		
		if(extInv.checkValidID(itemID) == false) {
			return "No such item in stock";
		}
		else {
			sale.addItem(itemID);
			return "item " + itemID + " added";
		} 
	}
	
	/**
	 * Ends the current sale instance, updates the stock of items in the inventory
	 * and computes the final cost of the sale
	 */
	
	public double endSale() {
		extInv.updateInventory(sale.getItemList());
		costOfSale = sale.terminateSale();
		return costOfSale;
	}
	
	/**
	 * This method is used to register payment from a customer
	 * @param amount this is the amount paid by the customer
	 * @param paymentType this is how the customer paid for the items, in this case cash
	 * @return  the amount to be returned to the customer
	 */
	
	public double pay(double amount, String paymentType) {
		double change = amount - costOfSale;
		return change;
	}
	
}

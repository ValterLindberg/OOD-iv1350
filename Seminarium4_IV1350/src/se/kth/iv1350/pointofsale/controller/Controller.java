package se.kth.iv1350.pointofsale.controller;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.model.Observer;

import java.util.*;

/**
 * This is the controller class of the program
 * which contains all the core methods of the application
 */

public class Controller {
	private ExternalInventorySystem extInv;
	private ExternalAccountingSystem extAcc;
	private Sale sale;
	private double costOfSale;
	private List<Observer> observers = new ArrayList<>();
	
	
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
		
		for(Observer observer : observers) {
			sale.addObserver(observer);
		}
	}
	
	/**
	 * Scans a given item, if item ID is invalid it moves on to the next item,
	 * if valid it adds the item to the list
	 * @param itemID item identification used to check item validity
	 * Throws either a database or invalid ID exception if the itemID is
	 * equivalent to either of the pre-determined values, and prints
	 * an explanatory error message
	 */
	
	public String scanItem(int itemID) throws DatabaseNotRunningException, InvalidItemIDException {
		
		try {	
			
			if(itemID != 13 || itemID != 123) {
				sale.addItem(itemID);
			}	
			return "item " + itemID + " added";
			} catch(DatabaseNotRunningException e) {
				System.err.println("ERROR: " + e.getMessage());
				throw e;
			}catch(InvalidItemIDException e) {
				System.err.println("ERROR: " + e.getMessage());
				throw e;
			}
		
		
		
		/*
		if(extInv.checkValidID(itemID) == false) {
			return "No such item in stock";
		}
		else {
			sale.addItem(itemID);
			return "item " + itemID + " added";
		} */
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
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
}

package se.kth.iv1350.pointofsale.model;


import java.time.LocalDateTime;
import java.util.*;

import se.kth.iv1350.pointofsale.integration.*;

/**
 * This class contains everything relevant to a sale instance.
 * It contains the methods that adds items, registers the time of a sale
 * terminates a sale instance etc.
 */

public class Sale {
	private LocalDateTime saleDateAndTime;
	private int saleID;
	private List<Item> itemList;
	private double totalVAT;
	private double runningTotal;
	private SaleDTO saleInfo;
	private ExternalInventorySystem extInv;
	private ExternalAccountingSystem extAcc;
	
	private List<Observer> observers = new ArrayList<>();
	
	/**
	 * Creates a new sale instance with a unique ID and time stamp
	 * @param extInv used to access the inventory system
	 * @param extAcc used to access the accounting system
	 */

	public Sale(ExternalInventorySystem extInv, ExternalAccountingSystem extAcc) {
		timeOfSale();
		Random r = new Random();
		this.saleID = r.nextInt(10);
		this.itemList = new ArrayList<Item>();
		this.totalVAT = 0;
		this.runningTotal = 0;
		this.saleInfo = new SaleDTO(runningTotal,totalVAT,itemList,saleDateAndTime,saleID);
		this.extInv = extInv;
		this.extAcc = extAcc;
	}
	
	private void timeOfSale() {
		this.saleDateAndTime = LocalDateTime.now();
	}
	
	/**
	 * Adds an item to the list of items to be bought
	 * @param itemID the unique integer value used to identify an item
	 * throws invalid ID exception if item ID is 13
	 * throws database not running exception if ID is 123
	 */
	
	public void addItem(int itemID) throws DatabaseNotRunningException, InvalidItemIDException {
		Item item = extInv.getItem(itemID);
		
		if(hasBeenScanned(item) == true) {
			item.incrementSoldItemQuantity();
			updateSaleInfo(item.getItemPrice(),item.getItemVatRate() ,itemList);
		}
		else {
			itemList.add(item);
			item.setSoldItemQuantity(1);
			updateSaleInfo(item.getItemPrice(),item.getItemVatRate(),itemList);
		}
	}
	
	private boolean hasBeenScanned(Item item) {
		for(Item i : itemList) {
			if(i.getItemID() == item.getItemID()) {
				return true;
			}
		}
		
		return false;
	}
	
	private void updateSaleInfo(double price, double VAT, List<Item> itemList) {
		this.runningTotal += price;
		this.totalVAT += VAT;
		this.saleInfo = new SaleDTO(runningTotal,totalVAT,itemList,this.saleDateAndTime,this.saleID);
	}
	
	/**
	 * Ends the current sale instance, updates external systems with
	 * the relevant information, prints receipt and returns total
	 * cost of the sale.
	 * @return the total cost of all items bought
	 */
	
	public double terminateSale() {
		extAcc.registerSale(saleInfo);
		extAcc.updateRegisterBalance(saleInfo.getTotalPrice());
		
		Receipt receipt = new Receipt(saleInfo);
		Printer printer = new Printer();
		printer.printReceipt(receipt);
		
		notifyObservers(saleInfo.getTotalPrice());
		
		return saleInfo.getTotalPrice();
		
	}
	
	/**
	 * Retrieves list of items the customer is going to buy
	 * @return list of items in a sale instance
	 */
	
	public List<Item> getItemList(){
		return this.itemList;
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(double runningTotal) {
		for(Observer observer : observers) {
			observer.updateTotalRevenue(runningTotal);
		}
	}
}

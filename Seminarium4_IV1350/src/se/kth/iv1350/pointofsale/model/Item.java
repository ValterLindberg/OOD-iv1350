package se.kth.iv1350.pointofsale.model;

/**
 * This class contains all the relevant information about
 * a particular item
 */

public class Item {
	private int itemID;
	private double itemPrice;
	private String itemDescription;
	private int quantity;
	private double vatRate;
	private int soldItemQuantity;

	/**
	 * Creates a new Item instance, parameters specify its characteristics
	 * @param itemID number used to identify the item
	 * @param itemPrice the cost of the item
	 * @param itemDescription name, weight, etc of an item
	 * @param quantity how much of an item there is in stock in the store
	 * @param vatRate vat rate for an item
	 */
	
	public Item(int itemID, double itemPrice, String itemDescription, 
				int quantity, double vatRate, int soldItemQuantity){
		this.itemID = itemID;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.vatRate = vatRate;
		this.soldItemQuantity = soldItemQuantity;
	}
	
	/**
	 * Retrieves ID of an item
	 * @return item ID
	 */
	
	public int getItemID() {
		return this.itemID;
	}
	
	/**
	 * Retrieves price of an item
	 * @return item price
	 */
	
	public double getItemPrice() {
		return this.itemPrice;
	}
	
	public String getItemDescription() {
		return this.itemDescription;
	}
	
	/**
	 * Retrieves quantity of an item
	 * @return item quantity
	 */
	
	public int getItemQuantity() {
		return this.quantity;
	}
	
	/**
	 * Retrieves vat rate of an item
	 * @return item vat rate
	 */
	
	public double getItemVatRate() {
		return this.vatRate;
	}
	
	public int getSoldItemQuantity() {
		return this.soldItemQuantity;
	}
	
	public void setSoldItemQuantity(int soldItemQuantity) {
		this.soldItemQuantity = soldItemQuantity;
	}
	
	public void incrementSoldItemQuantity() {
		this.soldItemQuantity++;
	}
	
	/**
	 * Helper function to determine how many of a particular item
	 * is left in stock after a sale is completed
	 * @param quantity number of items in stock
	 * @param numberSold how many of a particular item has been sold in a particular sale instance
	 * @param item updated information about item quantity
	 * @return the newly created item with updated quantity
	 */
	
	public Item updateItemQuantity(int quantity, int numberSold, Item item) {
		quantity = item.getItemQuantity() - numberSold;
		Item i = new Item(item.getItemID(), item.getItemPrice(),
				item.getItemDescription(), quantity, item.getItemVatRate(), numberSold);
		return i;
	}
}

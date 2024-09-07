package se.kth.iv1350.pointofsale.model;

import java.util.List;
import java.time.LocalDateTime;

/**
 * This class is used to store and pass around the information
 * of a particular sale instance
 */

public class SaleDTO {
	private double totalPrice;
	private double totalVAT;
	private List<Item> itemList;
	private LocalDateTime saleDateAndTime;
	private int saleID;
	private String storeName = "Paul's spice";
	
	/**
	 * Creates a new SaleDTO instance
	 * @param price running total of a sale
	 * @param totalVAT total vat of sale
	 * @param itemList list of items in a sale
	 * @param saleDateAndTime date and time the sale took place
	 * @param saleID unique integer used to identify a sale instance
	 */
	
	public SaleDTO(double price,double totalVAT, List<Item> itemList,
					LocalDateTime saleDateAndTime, int saleID) {
		this.totalPrice = price;
		this.totalVAT = totalVAT;
		this.itemList = itemList;
		this.saleDateAndTime = saleDateAndTime;
		this.saleID = saleID;
	}
	
	/**
	 * Retrieves the current/final total price of a sale
	 * @return total price of a sale
	 */
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	/**
	 * Retrieves the current/final total vat of a sale
	 * @return total vat of a sale
	 */
	
	public double getTotalVAT() {
		return this.totalVAT;
	}
	
	/**
	 * Retrieves the name of the store
	 * @return store name
	 */
	
	public String getStoreName() {
		return this.storeName;
	}
	
	/**
	 * Retrieves the current/final list of items in a sale instance
	 * @return list of items in a sale
	 */
	
	public List<Item> getItemList(){
		return this.itemList;
	}
	
	/**
	 * Retrieves the time and date when the sale took place
	 * @return time and date of the sale
	 */
	
	public LocalDateTime getSaleTime() {
		return this.saleDateAndTime;
	}
	
	/**
	 * Retrieves the unique integer value used to identify a sale instance
	 * @return ID of a particular sale instance
	 */

	public int getSaleID() {
		return this.saleID;
	}
}

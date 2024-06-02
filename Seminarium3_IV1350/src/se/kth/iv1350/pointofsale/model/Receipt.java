package se.kth.iv1350.pointofsale.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This class represents a receipt containing all information
 * about a sale instance
 */

public class Receipt {
	private SaleDTO saleInfo;
	private LocalDateTime saleDateAndTime;
	private List<Item> itemList;
	private double totalPrice;
	private double totalVAT;
	private String paymentType;
	private int saleID;
	private String storeName = "Paul's spice";
	
	/**
	 * Creates a receipt using the information from a given sale instance
	 * @param saleInfo specific information about a sale instance
	 */
	
	public Receipt(SaleDTO saleInfo) {
		this.saleInfo = saleInfo;
		this.saleDateAndTime = saleInfo.getSaleTime();
		this.itemList = saleInfo.getItemList();
		this.totalPrice = saleInfo.getTotalPrice();
		this.totalVAT = saleInfo.getTotalVAT();
		this.paymentType = "cash";
		this.saleID = saleInfo.getSaleID();
	}
	
	/**
	 * Retrieves the SaleDTO containing all the information about a sale instance
	 * @return sale instance information
	 */
	
	public SaleDTO getSaleInfo() {
		return this.saleInfo;
	}
	
	/**
	 * Retrieves the time and date which the sale took place
	 * @return time and date of the sale
	 */
	
	public LocalDateTime getSaleTime() {
		return this.saleDateAndTime;
	}
	
	/**
	 * Retrieves the list of sold items in the sale instance
	 * @return the list of items sold
	 */
	
	public List<Item> getItemList(){
		return this.itemList;
	}
	
	/**
	 * Retrieves the total cost of all the items purchased
	 * @return the total price of the sale
	 */
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	/**
	 * Retrieves the total vat of the sale
	 * @return the total vat as a float value
	 */
	
	public double getTotalVAT() {
		return this.totalVAT;
	}
	
	/**
	 * Retrieves the method by which the customer payed for the items
	 * @return method of payment
	 */
	
	public String getPaymentType() {
		return this.paymentType;
	}
	
	/**
	 * Retrieves the ID number of a particular sale instance
	 * @return the sale instance ID
	 */
	
	public int getSaleID() {
		return this.saleID;
	}
	
	/**
	 * Retrieves the name of the store where the sale took place
	 * @return the store name
	 */
	
	public String getStoreName() {
		return this.storeName;
	}
	
}

package se.kth.iv1350.pointofsale.integration;

import java.util.*;
import se.kth.iv1350.pointofsale.model.*;

/**
 * This class receives a receipt containing all the information of
 * a particular sale instance, which it the prints
 */
public class Printer {
	
	/**
	 * Creates a new printer instance
	 */
	public Printer() {
		
	}
	
	/**
	 * This method prints a receipt containing all information about a sale
	 * @param receipt contains information about a sale instance
	 * @param soldItemQuantity the quantity of each item sold in a sale
	 */
	
	public void printReceipt(Receipt receipt, List<Integer> soldItemQuantity) {
		
		
		System.out.println(receipt.getStoreName());
		System.out.println("Sale ID: " + receipt.getSaleID());
		System.out.println("\n " + receipt.getSaleTime());
		for(Item item : receipt.getItemList()) {
			System.out.println(soldItemQuantity.get(item.getItemID())+"x " + item.getItemDescription() + " " + item.getItemPrice()*soldItemQuantity.get(item.getItemID()) + "kr\n");
		}
		System.out.println("Total price: " + receipt.getTotalPrice());
		System.out.println("Total VAT rate: " + receipt.getTotalVAT());
		
	}
	
	
}

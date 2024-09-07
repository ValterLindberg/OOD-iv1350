package se.kth.iv1350.pointofsale.model;

/**
 * This class handles the discounts of a sale instance,
 * it is, however, not in use for this assignment
 */

public class Discount {
	
	/**
	 * Determines if a customer is eligible for a discount
	 * @param customerID ID number of a customer
	 * @return true if customer is eligible for a discount, false otherwise
	 */
	
	public boolean eligibleForDiscount(int customerID) {
		if(customerID == 999) {
			return true;
		}
		return false;
	}
	
	private double itemDiscount() {
		//discount not used in the implementation
		return 1.1;
	}
	
	/**
	 * This method is meant to compute the reduction in price after discount,
	 * it is not in use
	 * @param amount cost of a sale
	 * @return discounted cost
	 */
	
	public double totalDiscount(double amount) {
		//discount not used in the implementation
		return 1.1;
	}
}

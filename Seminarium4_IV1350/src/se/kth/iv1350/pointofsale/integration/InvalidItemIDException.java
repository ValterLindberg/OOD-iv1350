package se.kth.iv1350.pointofsale.integration;

/**
 * This exception is used when attempting to add an item
 * to the sale which is not in the inventory
 */

public class InvalidItemIDException extends Exception{
	
	/**
	 * The constructor for the InvalidItemID exception, prints
	 * an error message if an invalid ID is scanned
	 * @param errorMessage prints an error message explaining what went wrong
	 */
	
	public InvalidItemIDException(String errorMessage) {
		super(errorMessage);
	}
	
	

}

package se.kth.iv1350.pointofsale.integration;

/**
 * This exception is used when the program attempts to
 * communicate with the database while it is unavailable
 * for whatever reason
 */

public class DatabaseNotRunningException extends Exception{
	
	/**
	 * The constructor for the unavailable database exception, prints
	 * an error message when attempting communication with offline database
	 * @param errorMessage prints an error message explaining what went wrong
	 */
	
	public DatabaseNotRunningException(String errorMessage) {
		super(errorMessage);
	}

}

package se.kth.iv1350.pointofsale.integration;

import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.pointofsale.model.*;

/**
 * This class handles the accounting of the store,
 * such as registering sale instances
 *
 */

public class ExternalAccountingSystem {
	private List<SaleDTO> saleLog;
	private double registerBalance;

	/**
	 * This constructor creates an instance with which to access the accounting system,
	 * a sale log in which to store sale instances,
	 * and sets the register balance to some hard-coded value
	 */
	
	public ExternalAccountingSystem() {
		this.saleLog = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			saleLog.add(null);
		}
		this.registerBalance = 2000;
	}
	
	/**
	 * Registers a sale instance in the sale log
	 * @param sdto the sale information of a particular sale instance
	 */
	
	public void registerSale(SaleDTO sdto) {
		saleLog.set(sdto.getSaleID(), sdto);
	}
	
	/**
	 * This method returns the sale log containing sale instances
	 * @return a list of sale instances
	 */
	
	public List<SaleDTO> getListOfSales(){
		return this.saleLog;
	}
	
	/**
	 * Updates the amount in the register
	 * @param amount the amount to add to the register after a completed sale
	 */
	
	public void updateRegisterBalance(double amount) {
		this.registerBalance += amount;
	}
	
	/**
	 * Returns the amount in the register
	 * @return the amount contained in the register
	 */
	
	public double getRegisterBalance() {
		return this.registerBalance;
	}
}

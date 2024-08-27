package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.*;
import java.util.*;
import se.kth.iv1350.pointofsale.integration.*;
/**
 * This class handles the inventory system of the store
 */

public class ExternalInventorySystem {
	private List<Item> storeItemStock = new ArrayList<Item>();
	
	/**
	 * Creates an instance with which to access the inventory system,
	 * it also stocks the store with items
	 */
	
	public ExternalInventorySystem() {
		this.storeItemStock.add(new Item(0,66.5,"Arvid Nordquist mellanrost",100,2.2,0));
		this.storeItemStock.add(new Item(1,10.5,"Kvisttomater 200g",100,2.2,0));
		this.storeItemStock.add(new Item(2,15,"Arla mellanmjölk 1L",100,2.2,0));
		this.storeItemStock.add(new Item(3,150,"Melange 10g",100,2.2,0));
	}
	
	/**
	 * This method checks if the ID of an item is valid
	 * @param itemID the ID number of a given item
	 * @return true if ID is valid, false if it is not
	 */
	
	public boolean checkValidID(int itemID) {
		return itemID != 13;
	}
	
	/**
	 * Retrieves an item from the store inventory
	 * @param itemID the ID of a given item
	 * @return the item found in the inventory using the item ID
	 */
	
	public Item getItem(int itemID)  {
		/*
		if(itemID == 13) {
			throw new InvalidItemIDException("No such item in stock");
		}
		if(itemID == 123) {
			throw new DatabaseNotRunningException("Database currently offline");
		}
		 */
		return storeItemStock.get(itemID);
	}
	
	/**
	 * Updates the store inventory by subtracting the number of items in stock
	 * with the amount of sold items
	 * @param soldItems list of all items sold in a sale instance
	 */
	
	public void updateInventory(List<Item> soldItems) {
		
		for(Item item : soldItems) {
			item = item.updateItemQuantity(storeItemStock.get(item.getItemID()).getItemQuantity(),soldItems.get(item.getItemID()).getSoldItemQuantity(), item);
			storeItemStock.set(item.getItemID(), item);
		}
		
	}

}

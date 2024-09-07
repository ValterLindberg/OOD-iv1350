package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.Observer;
import java.io.FileWriter;
import java.io.IOException;

public class TotalRevenueFileOutput implements Observer{
	private FileWriter logRevenue = null;
	private double totalAmount;
	
	public TotalRevenueFileOutput() {
		this.totalAmount = 0;
	}

	@Override
	public void updateTotalRevenue(double amount) {
		this.totalAmount += amount;
		
		try {
			logRevenue = new FileWriter("src/se/kth/iv1350/pointofsale/integration/totalRevenue.txt",true);
			logRevenue.write("Accumulated revenue is: " + totalAmount + "kr\n");
			logRevenue.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

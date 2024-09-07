package se.kth.iv1350.pointofsale.view;
import se.kth.iv1350.pointofsale.model.Observer;

public class TotalRevenueView implements Observer{
	private double totalAmount;
	
	public TotalRevenueView() {
		this.totalAmount = 0;
	}
	
	@Override
	public void updateTotalRevenue(double amount) {
		this.totalAmount += amount;
		System.out.println("Accumulated revenue is: " + totalAmount + "kr");
	}
	
}

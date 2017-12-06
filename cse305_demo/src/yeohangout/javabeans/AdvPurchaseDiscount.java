package yeohangout.javabeans;

import java.io.Serializable;

public class AdvPurchaseDiscount implements Serializable{

	private static final long serialVersionUID = 7485266561031819680L;
	
	private String AirlineID;
	private int Days;
	private double DiscountRate;
	
	public AdvPurchaseDiscount(String airlineID, int days, double discountRate) {
		super();
		AirlineID = airlineID;
		Days = days;
		DiscountRate = discountRate;
	}
	public String getAirlineID() {
		return AirlineID;
	}
	public void setAirlineID(String airlineID) {
		AirlineID = airlineID;
	}
	public int getDays() {
		return Days;
	}
	public void setDays(int days) {
		Days = days;
	}
	public double getDiscountRate() {
		return DiscountRate;
	}
	public void setDiscountRate(double discountRate) {
		DiscountRate = discountRate;
	}
	
	

}

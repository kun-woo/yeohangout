package yeohangout.javabeans;

import java.io.Serializable;

public class Revenue implements Serializable{

	private static final long serialVersionUID = 281126246516414673L;
	private String city;
	private double revenue;
	private String name;
	private int accountNo;
	private int SSN;
	private String airlineID;
	private int flightNo;
	
	public Revenue() {
		super();
	}

	public Revenue(String city, double revenue) {
		super();
		this.city = city;
		this.revenue = revenue;
	}

	public Revenue(double revenue, String name, int accountNo) {
		super();
		this.revenue = revenue;
		this.name = name;
		this.accountNo = accountNo;
	}
	
	public Revenue(int sSN, String name, double revenue) {
		super();
		this.revenue = revenue;
		this.name = name;
		SSN = sSN;
	}
	
	public Revenue(String airlineID, double revenue, int flightNo) {
		super();
		this.revenue = revenue;
		this.airlineID = airlineID;
		this.flightNo = flightNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

}

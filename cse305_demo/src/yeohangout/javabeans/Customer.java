package yeohangout.javabeans;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 191427404879390596L;
	
	private String name;
	private int accountNo;
	private int seatNo;
	private int flightNo;
	private String airlineID;
	private int legNo;
	
	public Customer(String name, int accountNo, int seatNo, int flightNo, String airlineID, int legNo) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.seatNo = seatNo;
		this.flightNo = flightNo;
		this.airlineID = airlineID;
		this.legNo = legNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirlineID() {
		return airlineID;
	}
	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}
	public int getLegNo() {
		return legNo;
	}
	public void setLegNo(int legNo) {
		this.legNo = legNo;
	}
	
	
}
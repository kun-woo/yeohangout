package yeohangout.javabeans;

import java.util.Date;

public class Includes {
	private int ResrNo;
	private String AirlineID;
	private int flightNo;
	private int legNo;
	private Date date;
	
	
	public Includes() {}


	public int getResrNo() {
		return ResrNo;
	}


	public void setResrNo(int resrNo) {
		ResrNo = resrNo;
	}


	public String getAirlineID() {
		return AirlineID;
	}


	public void setAirlineID(String airlineID) {
		AirlineID = airlineID;
	}


	public int getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}


	public int getLegNo() {
		return legNo;
	}


	public void setLegNo(int legNo) {
		this.legNo = legNo;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
}

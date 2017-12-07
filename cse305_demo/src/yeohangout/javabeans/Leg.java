package yeohangout.javabeans;

import java.util.Date;

public class Leg {
	private String airlineID;
	private int flightNo;
	private int legNo;
	private int secondLegNO;
	private String depAirportID;
	private String arrAirportID;
	private Date depDate;
	private Date arrDate;
	
	public Leg() {
		
	}

	public String getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
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

	public String getDepAirportID() {
		return depAirportID;
	}

	public void setDepAirportID(String depAirportID) {
		this.depAirportID = depAirportID;
	}

	public String getArrAirportID() {
		return arrAirportID;
	}

	public void setArrAirportID(String arrAirportID) {
		this.arrAirportID = arrAirportID;
	}

	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public Date getArrDate() {
		return arrDate;
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public int getSecondLegNO() {
		return secondLegNO;
	}

	public void setSecondLegNO(int secondLegNO) {
		this.secondLegNO = secondLegNO;
	}	
	
	
}

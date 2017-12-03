package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Flight implements Serializable{
	private static final long serialVersionUID = -1888423918006538970L;
	
	private String airlineID;
	private int flightNumber;
	private int numberOfSeats;
	private String DaysOperating;
	private int minLenStay;
	private int maxLenStay;
	private String airportName;
	private String airportID;
	private int legNumber;
	private Timestamp expected;
	private Timestamp actual;
	
	public Flight() {}
	
	public Flight(String airlineID, int flightNumber, int numberOfSeats, String daysOperating, int minLenStay,
			int maxLenStay) {
		super();
		this.airlineID = airlineID;
		this.flightNumber = flightNumber;
		this.numberOfSeats = numberOfSeats;
		DaysOperating = daysOperating;
		this.minLenStay = minLenStay;
		this.maxLenStay = maxLenStay;
	}
	
	public Flight(String airlineID, int flightNumber, int maxLenStay) {
		super();
		this.airlineID = airlineID;
		this.flightNumber = flightNumber;
		this.maxLenStay = maxLenStay;
	}

	public Flight(String airportID, String airportName, String airlineID, int flightNumber) {
		super();
		this.airlineID = airlineID;
		this.flightNumber = flightNumber;
		this.airportName = airportName;
		this.airportID = airportID;
	}
	
	public Flight(String airlineID, int flightNumber, int legNumber, String airportName, Timestamp expected,
			Timestamp actual) {
		super();
		this.airlineID = airlineID;
		this.flightNumber = flightNumber;
		this.airportName = airportName;
		this.legNumber = legNumber;
		this.expected = expected;
		this.actual = actual;
	}

	public String getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getDaysOperating() {
		return DaysOperating;
	}

	public void setDaysOperating(String daysOperating) {
		DaysOperating = daysOperating;
	}

	public int getMinLenStay() {
		return minLenStay;
	}

	public void setMinLenStay(int minLenStay) {
		this.minLenStay = minLenStay;
	}

	public int getMaxLenStay() {
		return maxLenStay;
	}

	public void setMaxLenStay(int maxLenStay) {
		this.maxLenStay = maxLenStay;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
	}

	public int getLegNumber() {
		return legNumber;
	}

	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}

	public Timestamp getExpected() {
		return expected;
	}

	public void setExpected(Timestamp expected) {
		this.expected = expected;
	}

	public Timestamp getActual() {
		return actual;
	}

	public void setActual(Timestamp actual) {
		this.actual = actual;
	}
	
}

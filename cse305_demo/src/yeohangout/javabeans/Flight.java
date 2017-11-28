package yeohangout.javabeans;

public class Flight {
	private String airlineID;
	private int flightNumber;
	private int numberOfSeats;
	private String DaysOperating;
	private int minLenStay;
	private int maxLenStay;
	
	public Flight() {}

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
}

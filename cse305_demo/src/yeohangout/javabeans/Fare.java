package yeohangout.javabeans;

public class Fare {
	String airlineID;
	int flightNO;
	String fareType;
	String classType;
	double fare;
	boolean isFlexible;
	boolean isDomestic;
	
	public Fare() {}
	public Fare(String airlineID, int flightNO, double fare) {
		this.airlineID = airlineID;
		this.flightNO = flightNO;
		this.fare = fare;
		this.fareType = "null";
		this.classType="economy";
		this.isDomestic=false;
		this.isFlexible = false;
	}

	public String getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}

	public int getFlightNO() {
		return flightNO;
	}

	public void setFlightNO(int flightNO) {
		this.flightNO = flightNO;
	}

	public String getFareType() {
		return fareType;
	}

	public void setFareType(String fareType) {
		this.fareType = fareType;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public boolean isFlexible() {
		return isFlexible;
	}

	public void setFlexible(boolean isFlexible) {
		this.isFlexible = isFlexible;
	}

	public boolean isDomestic() {
		return isDomestic;
	}

	public void setDomestic(boolean isDomestic) {
		this.isDomestic = isDomestic;
	}
	
	
	
}

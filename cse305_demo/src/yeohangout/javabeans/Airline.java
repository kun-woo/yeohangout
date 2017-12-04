package yeohangout.javabeans;

import java.io.Serializable;

public class Airline implements Serializable{
	private static final long serialVersionUID = -4929667085854599919L;
	private String arirlineID;
	private String airlineName;
	
	public Airline() {
		
	}

	//Good for you
	public String getArirlineID() {
		return arirlineID;
	}

	public void setArirlineID(String arirlineID) {
		this.arirlineID = arirlineID;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
}

package yeohangout.javabeans;

import java.sql.Timestamp;
import java.util.Date;

public class Includes {
	private int ResrNo;
	private String AirlineID;
	private int flightNo;
	private int legNo;
	private Date date;
	private Timestamp dateTime;
	
	
	public Includes() {}

	public Includes(int resrNo, String airlineID, int flightNo, int legNo, Timestamp dateTime) {
		super();
		ResrNo = resrNo;
		AirlineID = airlineID;
		this.flightNo = flightNo;
		this.legNo = legNo;
		this.dateTime = dateTime;
	}
	
	public Includes(int resrNo, String airlineID, int flightNo, int legNo, Date date) {
		super();
		ResrNo = resrNo;
		AirlineID = airlineID;
		this.flightNo = flightNo;
		this.legNo = legNo;
		this.date = date;
	}

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

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}

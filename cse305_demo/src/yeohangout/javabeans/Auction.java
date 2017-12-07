package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Auction implements Serializable{

	private static final long serialVersionUID = 267578472752606419L;
	
	private int accoutNo;
	private String airline;
	private int flightNo;
	private String cabinClass;
	private Timestamp date;
	private double nyop;
	private boolean accepted;
	public Auction(int accoutNo, String airline, int flightNo, String cabinClass, Timestamp date, double nyop,
			boolean accepted) {
		super();
		this.accoutNo = accoutNo;
		this.airline = airline;
		this.flightNo = flightNo;
		this.cabinClass = cabinClass;
		this.date = date;
		this.nyop = nyop;
		this.accepted = accepted;
	}
	public int getAccoutNo() {
		return accoutNo;
	}
	public void setAccoutNo(int accoutNo) {
		this.accoutNo = accoutNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getCabinClass() {
		return cabinClass;
	}
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getNyop() {
		return nyop;
	}
	public void setNyop(double nyop) {
		this.nyop = nyop;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}

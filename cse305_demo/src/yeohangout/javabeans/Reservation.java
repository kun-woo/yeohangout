package yeohangout.javabeans;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
	private int resrNo;
	private Date resrDate;
	private double bookingFee;
	private double totalFare;
	private int repSSN;
	private int accountNo;
	private ArrayList<IncludeAndLeg> itineraries;
	
	public Reservation() {}

	public int getResrNo() {
		return resrNo;
	}

	public void setResrNo(int resrNo) {
		this.resrNo = resrNo;
	}

	public Date getResrDate() {
		return resrDate;
	}

	public void setResrDate(Date resrDate) {
		this.resrDate = resrDate;
	}

	public double getBookingFee() {
		return bookingFee;
	}

	public void setBookingFee(double bookingFee) {
		this.bookingFee = bookingFee;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public int getRepSSN() {
		return repSSN;
	}

	public void setRepSSN(int repSSN) {
		this.repSSN = repSSN;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public ArrayList<IncludeAndLeg> getItineraries() {
		return itineraries;
	}

	public void setItineraries(ArrayList<IncludeAndLeg> itineraries) {
		this.itineraries = itineraries;
	}
	
	
	
}

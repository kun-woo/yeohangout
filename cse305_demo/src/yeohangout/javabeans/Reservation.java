package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Reservation implements Serializable{
	private static final long serialVersionUID = -730050536098649031L;
	
	private int resrNo;
	private Date resrDate;
	private Timestamp resrDateTime;
	private double bookingFee;
	private double totalFare;
	private int repSSN;
	private int accountNo;
	
	
	public Reservation() {}

	public Reservation(int resrNo, Timestamp resrDateTime, double bookingFee, double totalFare, int repSSN,
			int accountNo) {
		super();
		this.resrNo = resrNo;
		this.resrDateTime = resrDateTime;
		this.bookingFee = bookingFee;
		this.totalFare = totalFare;
		this.repSSN = repSSN;
		this.accountNo = accountNo;
	}

	public Reservation(int resrNo, Timestamp resrDateTime, double bookingFee, double totalFare, int repSSN) {
		super();
		this.resrNo = resrNo;
		this.resrDateTime = resrDateTime;
		this.bookingFee = bookingFee;
		this.totalFare = totalFare;
		this.repSSN = repSSN;
	}

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
	
	
	
}

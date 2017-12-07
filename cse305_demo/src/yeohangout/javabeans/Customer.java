package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable{

	private static final long serialVersionUID = 191427404879390596L;
	
	private int id;
	private String name;
	private String fname;
	private String lname;
	private int accountNo;
	private int seatNo;
	private int flightNo;
	private String airlineID;
	private int legNo;
	private String creditCard;
	private Timestamp creDate;
	private int rating;
	private String userName;
	private String pwd;
	
	public Customer() {}
	
	public Customer(String fname, String lname, int accountNo, String creditCard, Timestamp creDate, int rating,
			String userName, String pwd) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.accountNo = accountNo;
		this.creditCard = creditCard;
		this.creDate = creDate;
		this.rating = rating;
		this.userName = userName;
		this.pwd = pwd;
	}

	public Customer(String name, int accountNo, int seatNo, int flightNo, String airlineID, int legNo) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.seatNo = seatNo;
		this.flightNo = flightNo;
		this.airlineID = airlineID;
		this.legNo = legNo;
	}

	public Customer(int id, String name, int accountNo, int seatNo, int flightNo, String airlineID, int legNo,
			String creditCard) {
		super();
		this.id = id;
		this.name = name;
		this.accountNo = accountNo;
		this.seatNo = seatNo;
		this.flightNo = flightNo;
		this.airlineID = airlineID;
		this.legNo = legNo;
		this.creditCard = creditCard;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirlineID() {
		return airlineID;
	}
	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}
	public int getLegNo() {
		return legNo;
	}
	public void setLegNo(int legNo) {
		this.legNo = legNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Timestamp getCreDate() {
		return creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}
	
	
	
}
package yeohangout.javabeans;

import java.sql.Date;

public class UserAccount {
	
	private int personID;
	private String userID;
	private String password;
	private int accountNo;
	private int creditCardNo;
	private Date accountCreationDate;
	private int Rating;
	
	public UserAccount() {
		
	}
	
	public int getPersonID() {
		return personID;
	}
	
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPasswor(String password) {
		this.password = password;
	}
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public int getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(int creditCardNo) {
		this.creditCardNo = creditCardNo;
	}


	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}
	
	
}

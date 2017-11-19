package yeohangout.javabeans;

import java.sql.Date;

public class UserAccount {
	public static final String MALE = "M";
	public static final String FEMALE = "F";
	
	private int userID;
	private int accountNo;
	private int creditCardNo;
	private Date accountCreationDate;
	private int Rating;
	
	public UserAccount() {
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

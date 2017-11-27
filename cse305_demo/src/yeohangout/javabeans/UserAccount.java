package yeohangout.javabeans;

import java.sql.Date;

public class UserAccount extends User{
	
	private int accountNo;
	private int creditCardNo;
	private Date accountCreationDate;
	private int Rating;
	
	public UserAccount() {
		
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

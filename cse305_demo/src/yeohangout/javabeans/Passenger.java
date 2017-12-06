package yeohangout.javabeans;

import java.io.Serializable;

public class Passenger implements Serializable{

	private static final long serialVersionUID = 3099071357252579244L;
	
	private int id;
	private int accountNo;
	
	public Passenger() {
		super();
	}
	public Passenger(int id, int accountNo) {
		super();
		this.id = id;
		this.accountNo = accountNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	

}

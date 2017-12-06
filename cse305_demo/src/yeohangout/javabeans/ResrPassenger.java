package yeohangout.javabeans;

import java.io.Serializable;

public class ResrPassenger implements Serializable{

	private static final long serialVersionUID = -8890408190030867876L;
	
	private int id;
	private int accountNo;
	public ResrPassenger(int id, int accountNo) {
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

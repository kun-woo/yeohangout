package yeohangout.javabeans;

import java.io.Serializable;

public class CustPreference implements Serializable{

	private static final long serialVersionUID = 7141674356865731878L;
	
	private int accountNo;
	private String preference;
	
	public CustPreference(int accountNo, String preference) {
		super();
		this.accountNo = accountNo;
		this.preference = preference;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	

}

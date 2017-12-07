package yeohangout.javabeans;

import java.io.Serializable;

public class MailList implements Serializable{

	private static final long serialVersionUID = -7410645099296821486L;
	private String name;
	private int accountNo;
	private String address;
	private String telephone;
	private String email;
	
	public MailList() {}
	
	public MailList(String name, int accountNo, String address, String telephone, String email) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package yeohangout.javabeans;

import java.io.Serializable;

public class ResrPassenger implements Serializable{

	private static final long serialVersionUID = -8890408190030867876L;
	private int resrNo;
	private int id;
	private int accountNo;
	private int seatNo;
	private String cabinClass;
	private String meal;
	
	
	public ResrPassenger(int resrNo, int id, int accountNo, int seatNo, String cabinClass, String meal) {
		super();
		this.resrNo = resrNo;
		this.id = id;
		this.accountNo = accountNo;
		this.seatNo = seatNo;
		this.cabinClass = cabinClass;
		this.meal = meal;
	}
	
	
	public int getResrNo() {
		return resrNo;
	}


	public void setResrNo(int resrNo) {
		this.resrNo = resrNo;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public String getCabinClass() {
		return cabinClass;
	}


	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}


	public String getMeal() {
		return meal;
	}


	public void setMeal(String meal) {
		this.meal = meal;
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

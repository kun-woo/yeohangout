package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Date;

public class Employee extends User implements Serializable{
	private static final long serialVersionUID = 6845959474282930823L;
	
	private int SSN;
	private boolean isManager;
	private Date startDate;
	private double hourlyRate;
	private String userName;
	private String pwd;
	
	public Employee() {}
	
	public Employee(int SSN, boolean isManager, Date startDate, double hourlyRate, String userName, String pwd) {
		this.SSN = SSN;
		this.isManager = isManager;
		this.startDate = startDate;
		this.hourlyRate = hourlyRate;
		this.userName = userName;
		this.pwd = pwd;
	}
	
	public int getSSN() {
		return SSN;
	}
	
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	
	public boolean isManager() {
		return isManager;
	}
	
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
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
	
}

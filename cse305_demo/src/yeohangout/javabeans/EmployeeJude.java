package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Date;


public class EmployeeJude implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private int id;
	private int SSN;
	private boolean isManager;
	private Date startDate;
	private double hourlyRate;
	private String userName;
	private String pwd;
	
	public EmployeeJude() {}
	
	public EmployeeJude(String firstName, String lastName, int SSN, boolean isManager, Date startDate, double hourlyRate, String userName, String pwd) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.isManager = isManager;
		this.startDate = startDate;
		this.hourlyRate = hourlyRate;
		this.userName = userName;
		this.pwd = pwd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

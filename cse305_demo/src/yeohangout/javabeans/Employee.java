package yeohangout.javabeans;

import java.io.Serializable;
import java.sql.Date;

public class Employee extends User implements Serializable{
	int SSN;
	boolean isManager;
	Date startDate;
	double hourlyRate;
	
	public Employee() {}
	
	public Employee(int SSN, boolean isManager, Date startDate, double hourlyRate) {
		this.SSN = SSN;
		this.isManager = isManager;
		this.startDate = startDate;
		this.hourlyRate = hourlyRate;
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
	
}

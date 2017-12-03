package yeohangout.javabeans;

import java.io.Serializable;

public class SalesReport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String month;
	private String revenue;
	
	public SalesReport() {}
	public SalesReport(String month, String revenue) {
		this.month = month;
		this.revenue = revenue;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

}

package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Airline;
import yeohangout.javabeans.Flight;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AddFlightServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletOutputStream out = response.getOutputStream();

		String contextPath = request.getContextPath();

		String airlineId = request.getParameter("airlineID");
		int flightNumber = Integer.parseInt(request.getParameter("flightNo"));
		int numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
		String daysOfOperating = request.getParameter("daysOp");
		int minLengthOfStay;
		int maxLengthOfStay;
		
		if(checkDaysOperating(daysOfOperating)) {
			
			Flight newFlight = new Flight();
	
			minLengthOfStay = parsingMinLengthOfStay(daysOfOperating);
			maxLengthOfStay = parsingMaxLengthOfStay(daysOfOperating);
			
			newFlight.setAirlineID(airlineId);
			newFlight.setFlightNumber(flightNumber);
			newFlight.setNumberOfSeats(numberOfSeats);
			newFlight.setDaysOperating(daysOfOperating);
			newFlight.setMinLenStay(minLengthOfStay);
			newFlight.setMaxLenStay(maxLengthOfStay);
			
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				if(AirlineUtils.searchFlight(connect, airlineId, flightNumber)==null){
					System.out.println("insert");
					AirlineUtils.insertFlight(connect, newFlight);
					// Insert new flight info to BackUp Database
					AirlineUtils.insertFlight(dao.getBackupConnection(), newFlight);
				}else {
					System.out.println("exists");
					//MyUtils.setIdAlreadyExists(true);
				}
				
				dao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("invalid op");
		}
		//Redirection to index.jsp
		
		response.sendRedirect(contextPath+"/dashboard-manager/employee_menu.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean checkDaysOperating(String daysOp) {
		
		if(daysOp.length()==7) {
			for(int i=0; i<daysOp.length(); i++) {
				if(daysOp.charAt(i)!='0'&&daysOp.charAt(i)!='1') {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
	
	private int parsingMinLengthOfStay(String daysOp) {
		int count =0; 
		int min = 7;
		boolean before = false;
		boolean touchZero = false;
		
		for(int i=0; i<daysOp.length(); i++) {
			if(daysOp.charAt(i)=='0') {
				count++;
				before = true;
				touchZero = true;
			}else {
				
				if(before==true&&min>count) {
					min = count;
				}
				count = 0;
				before = false;
			}
			
		}
		
		if(touchZero) {
			return min;
		}else {
			return 0;
		}
		
	}
	
	private int parsingMaxLengthOfStay(String daysOp) {
		int count =0; 
		int max = 0;
		boolean before = false;
		boolean touchOne = false;
		
		for(int i=0; i<daysOp.length(); i++) {
			if(daysOp.charAt(i)=='0') {
				count++;
				before = true;
			}else {
				
				if(before==true&&max<count) {
					max = count;
				}
				count = 0;
				before = false;

				touchOne = true;
			}
			
		}
		
		if(max<count) {
			max = count;
		}
		
		if(touchOne) {
			return max;
		}else {
			return 7;
		}
	}
}

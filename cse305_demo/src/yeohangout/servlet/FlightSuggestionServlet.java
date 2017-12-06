package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Flight;
import yeohangout.javabeans.IncludeAndLeg;
import yeohangout.javabeans.Leg;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.MySQLAccess;

@WebServlet(name = "flightSuggestion", urlPatterns= {"/flightSuggestion"})

public class FlightSuggestionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public FlightSuggestionServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();
		
		int accountNO = Integer.parseInt(request.getParameter("userID"));
		ArrayList<Leg> legs = null;
		ArrayList<Flight> flights = null;
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			legs = AirlineUtils.searchFlightByUserID( connect, accountNO);
			flights = AirlineUtils.searchFlighSuggestionBasedOnBestSeller(connect, accountNO);
			
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
		
		//Redirection to index.jsp
		request.setAttribute("legs", legs);		//send data from servlet to jsp
		request.setAttribute("flights", flights);
		System.out.println("FLIGHT" + flights.size());
		RequestDispatcher rd = request.getRequestDispatcher("/dashboard-customer/customer_flight_suggestion.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

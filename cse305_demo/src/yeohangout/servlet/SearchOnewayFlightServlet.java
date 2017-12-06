package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Leg;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.AirportUtils;
import yeohangout.mysql.FlightSearchUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;

@WebServlet(name = "searchOneway", urlPatterns= {"/searchOneway"})

public class SearchOnewayFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SearchOnewayFlightServlet() {
		super();
		
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();
		
		String depCity = request.getParameter("depCity");
		String depCountry = request.getParameter("depCountry");
		String depTimeString = request.getParameter("depTime");
		String arrCity = request.getParameter("arrCity");
		String arrCountry = request.getParameter("arrCountry");
		int passanger = Integer.parseInt(request.getParameter("num_of_passenger"));
		Date depTime  =null;
	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		ArrayList<Leg> searchedLegs = new ArrayList<Leg>();
		
		try {
			depTime = (java.util.Date)df.parse(depTimeString);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				Airport searchedDepAirport = AirportUtils.searchAirportByCityCountry(connect, depCity, depCountry);
				Airport searchedArrAirport = AirportUtils.searchAirportByCityCountry(connect, arrCity, arrCountry);
				if(searchedDepAirport!=null && searchedArrAirport!=null) {
					searchedLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedDepAirport.getID(), searchedArrAirport.getID(), depTime);
					
				}else {
					//Error
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
		
		if(searchedLegs.size()>0) {
			request.setAttribute("cu_reservations", searchedLegs);
		}//send data from servlet to jsp
		response.sendRedirect(contextPath+"/home-search/search-result.jsp");
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

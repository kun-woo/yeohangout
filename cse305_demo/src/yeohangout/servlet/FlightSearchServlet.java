package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Employee;
import yeohangout.javabeans.Leg;
import yeohangout.mysql.AirportUtils;
import yeohangout.mysql.FlightUtils;
import yeohangout.mysql.LegUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;

/**
 * Servlet implementation class FlightSearchServlet
 */
@WebServlet("/flightsearch")
public class FlightSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FlightSearchServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("---Connected to Flight Search Servlet---");

		RequestDispatcher rd = 	getServletContext()
								.getRequestDispatcher("/home-search/search_results.jsp");


		String depCity 		= request.getParameter("depCity");
		String depCountry 	= request.getParameter("depCountry");
		String arrCity 		= request.getParameter("arrCity");
		String arrCountry 	= request.getParameter("arrCountry");
		String depTime 		= request.getParameter("depTime");
		String arrTime 		= request.getParameter("arrTime");
		
		System.out.println("DepTime: " + depTime);
		System.out.println("ArrTime: " + arrTime);
		
		ArrayList<Airport> depAirports 	= new ArrayList<>();
		ArrayList<Airport> arrAirports 	= new ArrayList<>();
		ArrayList<Leg> validLegs 		= new ArrayList<>();
		
		// boolean submitButtonPressed = request.getParameter("submitBt") != null;
		
		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			request.setAttribute("numOfResults", validLegs.size());

			// Obtain all airports in the given departure city, country
			
			System.out.println("Departure: ");
			depAirports = AirportUtils.searchAirport(connect, depCity, depCountry);
			if(depAirports.isEmpty()) {

			}
			
			// Obtain all airports in the given arrival city, country
			
			System.out.println("Arrival: ");
			arrAirports = AirportUtils.searchAirport(connect, arrCity, arrCountry);
			if(arrAirports.isEmpty()) {

			}
			
			// Obtain all legs that satisfy the search requirement
			
			for(int i = 0; i < depAirports.size(); i++) {
				for(int j = 0; j < arrAirports.size(); j++) {
					ArrayList<Leg> currLegGroup = new ArrayList<>();
					currLegGroup = LegUtils.searchLeg(	connect, depAirports.get(i), 
														arrAirports.get(j), depTime, arrTime);
					validLegs.addAll(currLegGroup);
				}
			}
			
			System.out.println("Valid Legs : " + validLegs.size());
					
			
			request.setAttribute("numOfResults", validLegs.size());
			
			request.setAttribute("searchResults", validLegs);
			
			
			rd.forward(request, response);
		    
			dao.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

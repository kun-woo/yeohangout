package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.LegFlightAirport;
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
		
		//ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();
		
		String depCity = request.getParameter("depCity");
		String depCountry = request.getParameter("depCountry");
		String depTimeString = request.getParameter("depTime");
		
		String arrCity = request.getParameter("arrCity");
		String arrCountry = request.getParameter("arrCountry");
		String buttonType = request.getParameter("type_btn");
	
		
		Date depTime  =null;	
		Date returnTime = null;
	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy"); 
		
		try {
			depTime = (java.util.Date)df.parse(depTimeString);
			
			if(buttonType.equals("round-trip")) {
				String retTimeString = request.getParameter("returnTime");
				System.out.println("ret TIme : "+retTimeString);
				
				returnTime = (java.util.Date) df2.parse(retTimeString);
			}
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		ArrayList<LegFlightAirport> searchedLegs = new ArrayList<LegFlightAirport>();
		ArrayList<LegFlightAirport> searchedLegsBack = new ArrayList<LegFlightAirport>();
		
		MySQLAccess dao = null;
		
		
		try {
			dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			Airport searchedDepAirport = AirportUtils.searchAirportByCityCountry(connect, depCity, depCountry);
			Airport searchedArrAirport = AirportUtils.searchAirportByCityCountry(connect, arrCity, arrCountry);
		
			if(buttonType.equals("one-way")) {
				//one way
			
				if(searchedDepAirport!=null && searchedArrAirport!=null) {
					
					searchedLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedDepAirport.getID(), searchedArrAirport.getID(), depTime);
					
				}else {
					//Error
					
				}
			
			}else if(buttonType.equals("round-trip")) {
				System.out.println("Round Trip");
				
				if(searchedDepAirport!=null && searchedArrAirport!=null) {
					
					searchedLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedDepAirport.getID(), searchedArrAirport.getID(), depTime);
					searchedLegsBack = FlightSearchUtils.searchFlightByAirport(connect, searchedArrAirport.getID(), searchedDepAirport.getID(), returnTime);
				}else {
					//Error
					
				}
				
			}else {
				System.out.println("Multi");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.close();
		}
		
		
		request.setAttribute("searchLegs", searchedLegs);
		RequestDispatcher rd =null;
		
		if(buttonType.equals("one-way")) {
			rd = request.getRequestDispatcher("home-search/search-result.jsp");
		}else if(buttonType.equals("round-trip")) {
			request.setAttribute("backLegs", searchedLegsBack);
			rd = request.getRequestDispatcher("home-search/search-result-round.jsp");
		}
		
		rd.forward(request, response);
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

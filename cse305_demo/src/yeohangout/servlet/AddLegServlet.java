package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Flight;
import yeohangout.javabeans.Leg;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.MySQLAccess;

@WebServlet("/addLeg")
public class AddLegServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public AddLegServlet() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();

		String airlineId = request.getParameter("airlineID");
		int flightNumber = Integer.parseInt(request.getParameter("flightNo"));
		int legNo = Integer.parseInt(request.getParameter("legNo"));
		String depAirport = request.getParameter("depAirport");
		String arrAirport = request.getParameter("arrAirport");

		String depTime = request.getParameter("depDate");
		String arrTime = request.getParameter("arrDate");
		
		System.out.println("Dep : "+depTime+", Arr : "+arrTime);
		
		//parsing date 
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a"); 
		Date depDate = null;
		Date arrDate = null;
		
		try {
			depDate =  df.parse(depTime);
			arrDate =  df.parse(arrTime);
		} catch (ParseException e) {
		    e.printStackTrace();
		    response.sendRedirect(contextPath+"/employee_menu.jsp");
		}
		
		try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				//check that flight exists
				if(AirlineUtils.searchFlight(connect, airlineId, flightNumber)==null) {
					//Error message 
					//there is no such flight.
					System.out.println("no flight");
				} else if(AirlineUtils.searchAirport(connect, depAirport)==null || AirlineUtils.searchAirport(connect, arrAirport)==null) {
				//dep airport exists
					//error message
					//there is no such airport.
					System.out.println("no airport");
				} else if(AirlineUtils.searchLeg(connect, airlineId, flightNumber, legNo)!=null) {
					//check that the leg already exists.
					System.out.println("already exists");
				} else {
					//insert leg
					Leg newLeg = new Leg();
					
					newLeg.setAirlineID(airlineId);
					newLeg.setFlightNo(flightNumber);
					newLeg.setLegNo(legNo);
					newLeg.setDepAirportID(depAirport);
					newLeg.setArrAirportID(arrAirport);
					newLeg.setDepDate(depDate);
					newLeg.setArrDate(arrDate);
					
					AirlineUtils.insertLeg(connect, newLeg);

					System.out.println("Leg Inserted");
					
					
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
	
		
		response.sendRedirect(contextPath+"/employee_menu.jsp");
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
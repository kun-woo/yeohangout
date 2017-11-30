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
import yeohangout.javabeans.Airport;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.MySQLAccess;

@WebServlet("/addAirport")
public class AddAirportServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public AddAirportServlet() {
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

		String ID = request.getParameter("airportID");
		String name = request.getParameter("airportName");
		String city = request.getParameter("airportCity");
		String country = request.getParameter("airportCountry");
		
		Airport newAirport = new Airport();
		
		newAirport.setID(ID);
		newAirport.setName(name);
		newAirport.setCity(city);
		newAirport.setCountry(country);

		//Insert new user info to Database, This code will insert the sign up information into Person and Customer table.
		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			if(AirlineUtils.searchAirport(connect, ID)==null){
				AirlineUtils.insertAirport(connect, newAirport);
			}else {
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

		//Redirection to index.jsp
		response.sendRedirect(contextPath+"/employee_menu.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

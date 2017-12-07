package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.Airline;
import yeohangout.javabeans.Employee;
import yeohangout.javabeans.Person;
import yeohangout.javabeans.UserAccount;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;

@WebServlet("/addAirline")
public class AddAirlineServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AddAirlineServlet() {
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
		String airlineName = request.getParameter("airlineName");
		
		Airline newAirline = new Airline();

	
		newAirline.setArirlineID(airlineId);
		newAirline.setAirlineName(airlineName);
		

		//Insert new airline info to Database, This code will insert the sign up information into Airline table.
		try {
			MySQLAccess dao = new MySQLAccess();
			
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			if(AirlineUtils.searchAirline(connect, airlineId)==null){
				AirlineUtils.insertAirline(connect, newAirline);
				// Insert new airline info to BackUp Database
				
			}else {
				//MyUtils.setIdAlreadyExists(true);
			}
			dao.close();
		} catch(SQLException e) {
			response.sendRedirect(contextPath + "/error.jsp");
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			response.sendRedirect(contextPath + "/error.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect(contextPath + "/error.jsp");
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
}

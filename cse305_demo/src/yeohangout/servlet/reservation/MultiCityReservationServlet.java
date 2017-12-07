package yeohangout.servlet.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Leg;
import yeohangout.javabeans.LegFlightAirport;
import yeohangout.javabeans.Passenger;
import yeohangout.javabeans.Person;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;
import yeohangout.mysql.SingletonForMulticity;

@WebServlet(name = "multi-resr", urlPatterns = { "/multi-resr"})

public class MultiCityReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiCityReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		
		
		if(SingletonForMulticity.isValid()) {
			String airlineID = request.getParameter("airlineID");
			int flightNo = Integer.parseInt( request.getParameter("flightNO"));
			int legNO = Integer.parseInt(request.getParameter("legNO"));
			
			
			
			
			if(MyUtils.getUserType()==0) {
				
				try {
					MySQLAccess dao = new MySQLAccess();
					dao.readDataBase();
					Connection connect = null;
					connect = dao.getConnection();
					Leg selectedLeg = AirlineUtils.searchLeg(connect, airlineID, flightNo, legNO);
					
					if(SingletonForMulticity.getCount()==1) {
						SingletonForMulticity.setFirstLeg(new LegFlightAirport(selectedLeg));
					}else if(SingletonForMulticity.getCount()==2) {
						SingletonForMulticity.setSecondLeg(new LegFlightAirport(selectedLeg));
					}else if(SingletonForMulticity.getCount()==3){
						SingletonForMulticity.setThirdLeg(new LegFlightAirport(selectedLeg));
					}
					
					dao.close();
				}
				
				catch(Exception ex){
					ex.printStackTrace();
				}
				response.sendRedirect(contextPath+"/home-search/search-result-multi.jsp");
			}else {
				response.sendRedirect(contextPath+"/userNotFound.jsp");
				
			}
			//NEXT 
			
		}else {
			//Reservation
			response.sendRedirect(contextPath+"/home-search/search-summary.jsp");
		}
	}


}

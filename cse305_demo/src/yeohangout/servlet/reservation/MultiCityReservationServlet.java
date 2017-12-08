package yeohangout.servlet.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Fare;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.LegFlightAirport;
import yeohangout.javabeans.Passenger;
import yeohangout.javabeans.Person;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.FareUtils;
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
		if(MyUtils.getUserType()==0) {
			String loginedUser = request.getParameter("loginedUser");
			System.out.println("here");
		
			
			if(SingletonForMulticity.isValid()) {
				System.out.println("howw");
				String airlineID = request.getParameter("airlineID");
				int flightNo = Integer.parseInt( request.getParameter("flightNO"));
				int legNO = Integer.parseInt(request.getParameter("legNO"));
				
				
			
			
				try {
					MySQLAccess dao = new MySQLAccess();
					dao.readDataBase();
					Connection connect = null;
					connect = dao.getConnection();
					Leg selectedLeg = AirlineUtils.searchLeg(connect, airlineID, flightNo, legNO);
					
					if(SingletonForMulticity.getCount()==0) {
						SingletonForMulticity.setFirstLeg(new LegFlightAirport(selectedLeg));
						
						
						Airport depAirport = AirlineUtils.searchAirport(connect, SingletonForMulticity.getFirstLeg().getLeg().getDepAirportID());
						Airport arrAirport = AirlineUtils.searchAirport(connect, SingletonForMulticity.getFirstLeg().getLeg().getArrAirportID());
						Fare fare = FareUtils.searchFare(connect, SingletonForMulticity.getFirstLeg().getLeg().getAirlineID(), SingletonForMulticity.getFirstLeg().getLeg().getFlightNo());
						
						SingletonForMulticity.getFirstLeg().setDepAirport(depAirport);
						SingletonForMulticity.getFirstLeg().setArrAirport(arrAirport);
						SingletonForMulticity.getFirstLeg().setFare(fare);
						
						
						SingletonForMulticity.increaseCount();
						
					}else if(SingletonForMulticity.getCount()==1) {
						SingletonForMulticity.setSecondLeg(new LegFlightAirport(selectedLeg));
						
						Airport depAirport = AirlineUtils.searchAirport(connect, SingletonForMulticity.getSecondLeg().getLeg().getDepAirportID());
						Airport arrAirport = AirlineUtils.searchAirport(connect, SingletonForMulticity.getSecondLeg().getLeg().getArrAirportID());
						Fare fare = FareUtils.searchFare(connect, SingletonForMulticity.getSecondLeg().getLeg().getAirlineID(), SingletonForMulticity.getSecondLeg().getLeg().getFlightNo());
						
						SingletonForMulticity.getSecondLeg().setDepAirport(depAirport);
						SingletonForMulticity.getSecondLeg().setArrAirport(arrAirport);
						SingletonForMulticity.getSecondLeg().setFare(fare);
						
						
						SingletonForMulticity.increaseCount();
					}
					
					dao.close();
				} catch(Exception ex){
					ex.printStackTrace();
				}
				
				request.setAttribute("loginedUser", loginedUser);

				System.out.println("howw2");
				response.sendRedirect(contextPath+"/home-search/search-result-multi.jsp");
			} else {
			//Reservation
				
					
					if(SingletonForMulticity.getCount()==2){
						try {
							MySQLAccess dao = new MySQLAccess();
							dao.readDataBase();
							Connection connect = null;
							connect = dao.getConnection();
							
							String airlineID = request.getParameter("airlineID");
							int flightNo = Integer.parseInt( request.getParameter("flightNO"));
							int legNO = Integer.parseInt(request.getParameter("legNO"));
	
							Leg selectedLeg = AirlineUtils.searchLeg(connect, airlineID, flightNo, legNO);
							
							System.out.println("Third");
							SingletonForMulticity.setThirdLeg(new LegFlightAirport(selectedLeg));
							
							Airport depAirport = AirlineUtils.searchAirport(connect, SingletonForMulticity.getThirdLeg().getLeg().getDepAirportID());
							Airport arrAirport = AirlineUtils.searchAirport(connect, SingletonForMulticity.getThirdLeg().getLeg().getArrAirportID());
							Fare fare = FareUtils.searchFare(connect, SingletonForMulticity.getThirdLeg().getLeg().getAirlineID(), SingletonForMulticity.getThirdLeg().getLeg().getFlightNo());
							
							SingletonForMulticity.getThirdLeg().setDepAirport(depAirport);
							SingletonForMulticity.getThirdLeg().setArrAirport(arrAirport);
							SingletonForMulticity.getThirdLeg().setFare(fare);
							
						
							dao.close();
						} catch(Exception ex){
							ex.printStackTrace();
						}
					
				}
				
				
				System.out.println("howw3");
				RequestDispatcher rd = null;
				request.setAttribute("loginedUser", loginedUser);
				
				rd = request.getRequestDispatcher("/home-search/search-summary-multi.jsp");
				System.out.println("howw4 " + loginedUser);
				rd.forward(request, response);
			}	
		}else {
			//no user
			
			response.sendRedirect(contextPath+"/userNotFound.jsp");
				
		}
	}

}

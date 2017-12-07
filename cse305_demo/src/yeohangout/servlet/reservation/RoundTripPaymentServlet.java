package yeohangout.servlet.reservation;


import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Includes;
import yeohangout.javabeans.Reservation;
import yeohangout.javabeans.UserAccount;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.IncludeUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.ReservationUtils;
import java.io.IOException;

@WebServlet(name="paymentRoundTrip", urlPatterns= {"/paymentRoundTrip"})
public class RoundTripPaymentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public RoundTripPaymentServlet() {
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
			
			String airlineID = request.getParameter("airlineID");
			int flightNo = Integer.parseInt( request.getParameter("flightNo"));
			int legNO = Integer.parseInt(request.getParameter("legNo"));
			String userID = request.getParameter("userID");
			double totalFare = Double.parseDouble(request.getParameter("totalFare"));
			
			String airlineID2 = request.getParameter("airlineID2");
			int flightNo2 = Integer.parseInt( request.getParameter("flightNo2"));
			int legNO2 = Integer.parseInt(request.getParameter("legNo2"));
			double totalFare2 = Double.parseDouble(request.getParameter("totalFare2"));
			
			
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				//Insert reservation Table
				UserAccount user = DBUtils.searchUser(connect, userID);
				Reservation newResr = new Reservation();
				newResr.setResrDate(new java.util.Date());
				newResr.setBookingFee(10.00);
				newResr.setTotalFare(totalFare+totalFare2);
				newResr.setRepSSN(1234);
				newResr.setAccountNo(user.getAccountNo());
				
				ReservationUtils.insertReservation(connect, newResr);
				//Insert Includes Table
				
				//first
				Includes newInclude = new Includes();
				
				newInclude.setResrNo(newResr.getResrNo());
				newInclude.setAirlineID(airlineID);
				newInclude.setFlightNo(flightNo);
				newInclude.setLegNo(legNO);
				newInclude.setDate(newResr.getResrDate());
				
				IncludeUtils.insertInclude(connect, newInclude);
				
				//second
				Includes newInclude2 = new Includes();
				
				newInclude2.setResrNo(newResr.getResrNo());
				newInclude2.setAirlineID(airlineID2);
				newInclude2.setFlightNo(flightNo2);
				newInclude2.setLegNo(legNO2);
				newInclude2.setDate(newResr.getResrDate());
				
				IncludeUtils.insertInclude(connect, newInclude2);
				
			} catch(Exception ex){
				ex.printStackTrace();
			}
			response.sendRedirect(contextPath+"/home-search/search-confirm.jsp");
			
		}

	
}
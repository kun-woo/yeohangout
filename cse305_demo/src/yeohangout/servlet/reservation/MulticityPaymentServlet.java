package yeohangout.servlet.reservation;

import java.io.IOException;
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
import yeohangout.mysql.SingletonForMulticity;

@WebServlet(name = "paymentMulti", urlPatterns = {"/paymentMulti"})
public class MulticityPaymentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MulticityPaymentServlet() {
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
		
		String airlineID2=null;
		int flightNo2=-1;
		int legNO2=-1;
		double totalFare2=-1.1;
		
		String airlineID3=null;
		int flightNo3=-1;
		int legNO3 =-1;
		double totalFare3=-1.1;
		double realTotalFare = totalFare;
		
		if(SingletonForMulticity.getCount()>=1) {
		 airlineID2 = request.getParameter("airlineID2");
		 flightNo2 = Integer.parseInt( request.getParameter("flightNo2"));
		 legNO2 = Integer.parseInt(request.getParameter("legNo2"));
		 totalFare2 = Double.parseDouble(request.getParameter("totalFare2"));
		 realTotalFare+=totalFare2;
		}
		
		if(SingletonForMulticity.getCount()==2) {
			 airlineID3 = request.getParameter("airlineID3");
			 flightNo3 = Integer.parseInt( request.getParameter("flightNo3"));
			 legNO3 = Integer.parseInt(request.getParameter("legNo3"));
			 totalFare3 = Double.parseDouble(request.getParameter("totalFare3"));
			 realTotalFare+=totalFare3;	
		}
		
		
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
			newResr.setTotalFare(realTotalFare);
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
			
			if(SingletonForMulticity.getCount()>=1) {
			Includes newInclude2 = new Includes();
			
			newInclude2.setResrNo(newResr.getResrNo());
			newInclude2.setAirlineID(airlineID2);
			newInclude2.setFlightNo(flightNo2);
			newInclude2.setLegNo(legNO2);
			newInclude2.setDate(newResr.getResrDate());
			
			IncludeUtils.insertInclude(connect, newInclude2);
			}
			
			if(SingletonForMulticity.getCount()==2) {
				Includes newInclude3 = new Includes();
				
				newInclude3.setResrNo(newResr.getResrNo());
				newInclude3.setAirlineID(airlineID3);
				newInclude3.setFlightNo(flightNo3);
				newInclude3.setLegNo(legNO3);
				newInclude3.setDate(newResr.getResrDate());
				
				IncludeUtils.insertInclude(connect, newInclude3);
			}
			
			
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		response.sendRedirect(contextPath+"/home-search/search-confirm.jsp");
		
	}
}

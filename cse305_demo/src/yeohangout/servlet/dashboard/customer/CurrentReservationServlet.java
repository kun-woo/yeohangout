package yeohangout.servlet.dashboard.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Flight;
import yeohangout.javabeans.IncludeAndLeg;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.Reservation;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.IncludeUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.ReservationUtils;

@WebServlet("/currentReservationServlet")

public class CurrentReservationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CurrentReservationServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();
		
		int accountNO = Integer.parseInt(request.getParameter("userID"));
		ArrayList<Reservation> reservations = null;
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();


			reservations = ReservationUtils.searchReservationListByAccountNo(connect, accountNO);
			for(Reservation res : reservations) {
				ArrayList<IncludeAndLeg> itineraries = IncludeUtils.searchIncludesAndLegByResrNo(connect, res.getResrNo(), true);
				res.setItineraries(itineraries);
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
		request.setAttribute("cu_reservations", reservations);		//send data from servlet to jsp
		
		RequestDispatcher rd = request.getRequestDispatcher(contextPath+"/dashboard-customer/customer_current_resrv.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

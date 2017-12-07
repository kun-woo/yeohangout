package yeohangout.servlet.reservation;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Reservation;
import yeohangout.javabeans.UserAccount;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;

@WebServlet(name="payment", urlPatterns= {"/payment"})
public class PaymentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public PaymentServlet() {
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
			
			
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				//Insert reservation Table
				UserAccount user = DBUtils.searchUser(connect, userID);
				Reservation newReser = new Reservation();
				newReser.setResrDate(new java.util.Date());
				
				//Insert Includes Table
				
				
			} catch(Exception ex){
				ex.printStackTrace();
			}
			
		}

	
}

package yeohangout.servlet.dashboard.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.Reservation;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class GetReservationServlet
 */
@WebServlet(name = "view-reservation", urlPatterns = { "/view-reservation" })
public class GetReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetReservationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// This will load the MySQL driver, each DB has its own driver
		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM ResrData");
				rs = ps.executeQuery();

				ArrayList<Reservation> resrArr = new ArrayList<Reservation>();

				if (rs != null) {
					while (rs.next()) {
						resrArr.add(new Reservation(rs.getInt("ResrNo"), rs.getTimestamp("ResrDate"), rs.getDouble("BookingFee"), 
								rs.getDouble("TotalFare"), rs.getInt("RepSSN"), rs.getInt("AccountNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("resrArr", resrArr);
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-manager/dashboard-manager-employee.jsp");
					System.out.println("No user found with given input, please register first.");
					rd.include(request, response);
				}

			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					System.out.println("No user found with given input, please register first.");
				}
			}

			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM ResrFlightListInfo");
				rs = ps.executeQuery();

				ArrayList<Reservation> resrArrFlight = new ArrayList<Reservation>();

				if (rs != null) {
					while (rs.next()) {
						resrArrFlight.add(new Reservation(rs.getString("AirlineID"), rs.getInt("FlightNo"), 
								rs.getInt("ResrNo"), rs.getTimestamp("ResrDate"), rs.getDouble("BookingFee"), 
								rs.getDouble("TotalFare"), rs.getInt("RepSSN"), rs.getInt("AccountNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("resrArrFlight", resrArrFlight);
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-manager/dashboard-manager-employee.jsp");
					System.out.println("No user found with given input, please register first.");
					rd.include(request, response);
				}

			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					System.out.println("No user found with given input, please register first.");
				}
			}

			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM ResrCustList");
				rs = ps.executeQuery();

				ArrayList<Reservation> resrArrCust = new ArrayList<Reservation>();

				if (rs != null) {
					while (rs.next()) {
						resrArrCust.add(new Reservation(rs.getString("Name"), rs.getInt("AccountNo"), rs.getInt("ResrNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("resrArrCust", resrArrCust);
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-reservation.jsp");
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-manager/dashboard-manager-employee.jsp");
					System.out.println("No user found with given input, please register first.");
					rd.include(request, response);
				}
				
				connect.close();

			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					System.out.println("No user found with given input, please register first.");
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

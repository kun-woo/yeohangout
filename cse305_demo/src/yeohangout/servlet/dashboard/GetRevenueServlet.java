package yeohangout.servlet.dashboard;

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

import yeohangout.javabeans.Revenue;

/**
 * Servlet implementation class GetRevenue
 */
@WebServlet(name = "view-revenue", urlPatterns = { "/view-revenue" })
public class GetRevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetRevenueServlet() {
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
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://mysql2.cs.stonybrook.edu:3306/howoo?"
							+ "user=howoo&password=111255764");
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM RevnCity");
				rs = ps.executeQuery();

				ArrayList<Revenue> revnCityArr = new ArrayList<Revenue>();

				if (rs != null) {
					while (rs.next()) {
						revnCityArr.add(new Revenue(rs.getInt("ResrNo"), rs.getTimestamp("ResrDate"), rs.getDouble("BookingFee"), 
								rs.getDouble("TotalFare"), rs.getInt("RepSSN"), rs.getInt("AccountNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("revnCityArr", revnCityArr);
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
				ps = connect.prepareStatement("SELECT * FROM RevnCust");
				rs = ps.executeQuery();

				ArrayList<Revenue> revnCustArr = new ArrayList<Revenue>();

				if (rs != null) {
					while (rs.next()) {
						resrArrFlight.add(new Revenue(rs.getString("AirlineID"), rs.getInt("FlightNo"), 
								rs.getInt("ResrNo"), rs.getTimestamp("ResrDate"), rs.getDouble("BookingFee"), 
								rs.getDouble("TotalFare"), rs.getInt("RepSSN"), rs.getInt("AccountNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("revnCustArr", revnCustArr);
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
				ps = connect.prepareStatement("SELECT * FROM RevnCustRep");
				rs = ps.executeQuery();

				ArrayList<Revenue> revnCustRepArr = new ArrayList<Revenue>();

				if (rs != null) {
					while (rs.next()) {
						revnCustRepArr.add(new Revenue(rs.getString("Name"), rs.getInt("AccountNo"), rs.getInt("ResrNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("revnCustRepArr", revnCustRepArr);
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
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM RevnFlight");
				rs = ps.executeQuery();

				ArrayList<Revenue> resrArrCust = new ArrayList<Revenue>();

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

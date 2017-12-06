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

import yeohangout.javabeans.Revenue;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class GetRevenue
 */
@WebServlet(name = "view-total-revenue", urlPatterns = { "/view-total-revenue" })
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
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM RevnCity");
				rs = ps.executeQuery();

				ArrayList<Revenue> revnCityArr = new ArrayList<Revenue>();

				if (rs != null) {
					while (rs.next()) {
						revnCityArr.add(new Revenue(rs.getString("City"), rs.getDouble("Revenue")));
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
						revnCustArr.add(new Revenue(rs.getDouble("Revenue"), rs.getString("Name"), rs.getInt("AccountNo")));
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
						revnCustRepArr.add(new Revenue(rs.getInt("SSN"), rs.getString("Name"), rs.getDouble("Revenue")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("revnCustRepArr", revnCustRepArr);
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
				ps = connect.prepareStatement("SELECT * FROM RevnFlight");
				rs = ps.executeQuery();

				ArrayList<Revenue> revnFlightArr = new ArrayList<Revenue>();

				if (rs != null) {
					while (rs.next()) {
						revnFlightArr.add(new Revenue(rs.getString("AirlineID"), rs.getDouble("FlightNo"), rs.getInt("Revenue")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("revnFlightArr", revnFlightArr);
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-revenue.jsp");
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

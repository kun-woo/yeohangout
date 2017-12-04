package yeohangout.servlet.dashboard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.Flight;

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
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://mysql2.cs.stonybrook.edu:3306/howoo?"
							+ "user=howoo&password=111255764");
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM FlightListAll");
				rs = ps.executeQuery();

				ArrayList<Flight> flightArr = new ArrayList<Flight>();

				if (rs != null) {
					while (rs.next()) {
						flightArr.add(new Flight(rs.getString("AirlineID"), rs.getInt("FlightNo"), rs.getInt("NoOfSeats"), 
								rs.getString("DaysOperating"), rs.getInt("MinLengthOfStay"), rs.getInt("MaxLengthOfStay")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("flightArr", flightArr);
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
				ps = connect.prepareStatement("SELECT * FROM MostActFlight");
				rs = ps.executeQuery();

				ArrayList<Flight> flightArrActive = new ArrayList<Flight>();

				if (rs != null) {
					while (rs.next()) {
						flightArrActive.add(new Flight(rs.getString("AirlineID"), rs.getInt("FlightNo"), rs.getInt("MaxLengthOfStay")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("flightArrActive", flightArrActive);
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
				ps = connect.prepareStatement("SELECT * FROM FlightListAir");
				rs = ps.executeQuery();

				ArrayList<Flight> flightArrAirport = new ArrayList<Flight>();

				if (rs != null) {
					while (rs.next()) {
						flightArrAirport.add(new Flight(rs.getString("Id"), rs.getString("Airport"), rs.getString("AirlineID"), 
								rs.getInt("FlightNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("flightArrAirport", flightArrAirport);
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
				ps = connect.prepareStatement("SELECT * FROM Flightlistontime");
				rs = ps.executeQuery();

				ArrayList<Flight> flightArrOnTime = new ArrayList<Flight>();

				if (rs != null) {
					ResultSetMetaData rsmd = rs.getMetaData();                
					while (rs.next()) {
						flightArrOnTime.add(new Flight(rs.getString(rsmd.getColumnLabel(1)), rs.getInt(rsmd.getColumnLabel(2)), 
								rs.getInt(rsmd.getColumnLabel(3)), rs.getString(rsmd.getColumnLabel(4)), 
								rs.getTimestamp(rsmd.getColumnLabel(5)), rs.getTimestamp(rsmd.getColumnLabel(6))));
					}
					HttpSession session = request.getSession();
					session.setAttribute("flightArrOnTime", flightArrOnTime);
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
				ps = connect.prepareStatement("SELECT * FROM FlightListDelayed");
				rs = ps.executeQuery();

				ArrayList<Flight> flightArrDelayed = new ArrayList<Flight>();

				if (rs != null) {
					ResultSetMetaData rsmd = rs.getMetaData();                
					while (rs.next()) {
						flightArrDelayed.add(new Flight(rs.getString(rsmd.getColumnLabel(1)), rs.getInt(rsmd.getColumnLabel(2)), 
								rs.getInt(rsmd.getColumnLabel(3)), rs.getString(rsmd.getColumnLabel(4)), 
								rs.getTimestamp(rsmd.getColumnLabel(5)), rs.getTimestamp(rsmd.getColumnLabel(6))));
					}
					HttpSession session = request.getSession();
					session.setAttribute("flightArrDelayed", flightArrDelayed);
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-flight.jsp");
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

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

import yeohangout.javabeans.Flight;

/**
 * Servlet implementation class GetFlightServlet
 */
@WebServlet(name = "view-flight", urlPatterns = { "/view-flight" })
public class GetFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFlightServlet() {
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
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-flight.jsp");
			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-manager/dashboard-manager-employee.jsp");
				System.out.println("No user found with given input, please register first.");
				rd.include(request, response);
			}

			connect.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				System.out.println("No user found with given input, please register first.");
			}
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

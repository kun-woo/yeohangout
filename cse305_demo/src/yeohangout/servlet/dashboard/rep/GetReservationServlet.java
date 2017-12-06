package yeohangout.servlet.dashboard.rep;

import java.io.IOException;
import java.io.PrintWriter;
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

import yeohangout.javabeans.Includes;
import yeohangout.javabeans.Passenger;
import yeohangout.javabeans.Reservation;
import yeohangout.javabeans.ResrPassenger;

/**
 * Servlet implementation class GetReservationServlet
 */
@WebServlet(name = "view-rep-reservation", urlPatterns = { "/view-rep-reservation" })
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
			ArrayList<Reservation> resrArr = new ArrayList<Reservation>();
			ArrayList<Passenger> passArr = new ArrayList<Passenger>();
			ArrayList<Includes> inclArr = new ArrayList<Includes>();
			ArrayList<ResrPassenger> resrPassArr = new ArrayList<ResrPassenger>();
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM Reservation");
				rs = ps.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						resrArr.add(new Reservation(rs.getInt("ResrNo"), rs.getTimestamp("ResrDate"), rs.getDouble("BookingFee"), rs.getDouble("TotalFare"), 
								rs.getInt("RepSSN"), rs.getInt("AccountNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("resrArr", resrArr);
					
				}
				else {
					String contextPath = request.getContextPath();
					RequestDispatcher rd = getServletContext().getRequestDispatcher(contextPath + "/dashboard-rep/dashboard-rep-overview.jsp");
					PrintWriter out= response.getWriter();
					out.println("<font color=red>No user found with given input, please register first.</font>");
					rd.include(request, response);
				}
			} finally {
				ps.close();
				rs.close();
			}
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM Passenger");
				rs = ps.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						passArr.add(new Passenger(rs.getInt("Id"), rs.getInt("AccountNo")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("passArr", passArr);
					
				}
				else {
					String contextPath = request.getContextPath();
					RequestDispatcher rd = getServletContext().getRequestDispatcher(contextPath + "/dashboard-rep/dashboard-rep-overview.jsp");
					PrintWriter out= response.getWriter();
					out.println("<font color=red>No user found with given input, please register first.</font>");
					rd.include(request, response);
				}
			} finally {
				ps.close();
				rs.close();
			}
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM Includes");
				rs = ps.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						inclArr.add(new Includes(rs.getInt("ResrNo"), rs.getString("AirlineID"), rs.getInt("FlightNo"), rs.getInt("LegNo"), 
								rs.getTimestamp("Date")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("inclArr", inclArr);
					
				}
				else {
					String contextPath = request.getContextPath();
					RequestDispatcher rd = getServletContext().getRequestDispatcher(contextPath + "/dashboard-rep/dashboard-rep-overview.jsp");
					PrintWriter out= response.getWriter();
					out.println("<font color=red>No user found with given input, please register first.</font>");
					rd.include(request, response);
				}
			} finally {
				ps.close();
				rs.close();
			}
			
			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM ReservationPassenger");
				rs = ps.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						resrPassArr.add(new ResrPassenger(rs.getInt("ResrNo"), rs.getInt("Id"), rs.getInt("AccountNo"), rs.getInt("SeatNo"), 
								rs.getString("Class"), rs.getString("Meal")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("resrPassArr", resrPassArr);
					
				}
				else {
					String contextPath = request.getContextPath();
					RequestDispatcher rd = getServletContext().getRequestDispatcher(contextPath + "/dashboard-rep/dashboard-rep-overview.jsp");
					PrintWriter out= response.getWriter();
					out.println("<font color=red>No user found with given input, please register first.</font>");
					rd.include(request, response);
				}
			} finally {
				ps.close();
				rs.close();
			}

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/dashboard-rep/dashboard-rep-record.jsp");
			connect.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				PrintWriter out= response.getWriter();
				out.println("SQLException in closing PreparedStatement or ResultSet");
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

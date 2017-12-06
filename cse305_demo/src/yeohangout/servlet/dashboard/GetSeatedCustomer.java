package yeohangout.servlet.dashboard;

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

import yeohangout.javabeans.Customer;

/**
 * Servlet implementation class GetSeatedCustomer
 */
@WebServlet(name = "view-customer-seated", urlPatterns = { "/view-customer-seated" })
public class GetSeatedCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSeatedCustomer() {
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
			ps = connect.prepareStatement("SELECT *"
					+ "FROM CustSeat");
			rs = ps.executeQuery();

			ArrayList<Customer> custArr = new ArrayList<Customer>();

			if (rs != null) {
				while (rs.next()) {
					custArr.add(new Customer(rs.getString("Name"), rs.getInt("AccountNo"), rs.getInt("SeatNo"), rs.getInt("FlightNo"), rs.getInt("Airline ID"), rs.getInt("LegNo")));
				}
				HttpSession session = request.getSession();
				session.setAttribute("custArr", custArr);
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-customer.jsp");
			}
			else {
				String contextPath = request.getContextPath();
				RequestDispatcher rd = getServletContext().getRequestDispatcher(contextPath + "/dashboard-manager/dashboard-manager-salesreport.jsp");
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

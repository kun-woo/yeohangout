package yeohangout.servlet.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet(name = "add-employee", urlPatterns = { "/add-employee" })
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int SSN = Integer.parseInt(request.getParameter("SSN"));
		boolean isManager = Boolean.parseBoolean(request.getParameter("isManager"));
		double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String errorMsg = null;
//		Date startDate = null;
//		java.sql.Date  sqlDate = null;
//		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		
		if (firstName == null || firstName.equals("")) {
			errorMsg = "Input Null";
		}
		if (lastName == null || lastName.equals("")) {
			errorMsg = "Input Null";
		}
		if (SSN == 0) {
			errorMsg = "Input 0";
		}
		if (userName == null || userName.equals("")) {
			errorMsg = "Input Null";
		}
		if (pwd == null || pwd.equals("")) {
			errorMsg = "Input Null";
		}
//		try {
//			startDate = (Date) format.parse(request.getParameter("startDate"));
//			sqlDate = new java.sql.Date(startDate.getTime());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (errorMsg != null){
			PrintWriter out= response.getWriter();
			out.println(errorMsg);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-overview.jsp");
			
		}
		else {
			// This will load the MySQL driver, each DB has its own driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Setup the connection with the DB
				Connection connect = DriverManager
						.getConnection("jdbc:mysql://mysql2.cs.stonybrook.edu:3306/howoo?"
								+ "user=howoo&password=111255764");
				try {
					// Execute SQL query
					ps = connect.prepareStatement("INSERT into Person(FirstName, LastName, Address, City, State, Zipcode)"
							+ "values(?, ?, ?, ?, ?, ?)");
					ps.setString(1, firstName);
					ps.setString(2, lastName);
					ps.setString(3, "unknown");
					ps.setString(4, "unknown");
					ps.setString(5, "unknown");
					ps.setInt(6, 11790);
					ps.execute();

				} finally {
					try {
						ps.close();
					} catch (SQLException e) {
						PrintWriter out= response.getWriter();
						out.println("SQLException in closing PreparedStatement or ResultSet");
					}
				}

				try {
					// Execute SQL query
					ps = connect.prepareStatement("INSERT into Employee(Id, SSN, IsManager, StartDate, "
							+ "HourlyRate, UserName, Pwd)"
							+ "values(?, ?, ?, now(), ?, ?, ?)");
					ps.setInt(1, 6);
					ps.setInt(2, SSN);
					ps.setBoolean(3, isManager);
					ps.setDouble(4, hourlyRate);
					ps.setString(5, userName);
					ps.setString(6, pwd);
					ps.execute();

					PrintWriter out= response.getWriter();
					out.println("<font color=green>Add successful, please check table.</font>");
					
					response.sendRedirect("view-employee");
					
					connect.close();
				} finally {
					try {
						ps.close();
					} catch (SQLException e) {
						PrintWriter out= response.getWriter();
						out.println("SQLException in closing PreparedStatement or ResultSet");
					}
				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	}

}

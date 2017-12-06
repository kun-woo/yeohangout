package yeohangout.servlet.dashboard.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.EmployeeJude;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet(name = "view-employee", urlPatterns = { "/view-employee" })
public class GetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmployeeServlet() {
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
			
			// Execute SQL query
			ps = connect.prepareStatement("SELECT p.FirstName, p.LastName, e.SSN, e.isManager, e.StartDate, "
					+ "e.HourlyRate, e.UserName, e.Pwd "
					+ "FROM Employee e LEFT JOIN Person P ON p.Id = e.Id");
			rs = ps.executeQuery();
			
			ArrayList<EmployeeJude> emplArr = new ArrayList<EmployeeJude>();

			if (rs != null) {
					while (rs.next()) {
						emplArr.add(new EmployeeJude(rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("SSN"), rs.getBoolean("isManager"), 
						rs.getDate("StartDate"), rs.getDouble("HourlyRate"), rs.getString("UserName"), rs.getString("Pwd")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("emplArr", emplArr);
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-employee.jsp");
				}
			else {
				String contextPath = request.getContextPath();
				RequestDispatcher rd = getServletContext().getRequestDispatcher(contextPath + "/dashboard-manager/dashboard-manager-employee.jsp");
				PrintWriter out= response.getWriter();
				out.println("<font color=red>No user found with given input, please register first.</font>");
				rd.include(request, response);
			}
			
			connect.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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

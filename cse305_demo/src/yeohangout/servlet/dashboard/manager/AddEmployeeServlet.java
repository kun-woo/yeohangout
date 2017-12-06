package yeohangout.servlet.dashboard.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.EmployeeJude;
import yeohangout.javabeans.Person;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet(name = "add-employee", urlPatterns = { "/add-employee" })
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			
			//make person object
			Person newPerson = new Person();
			
			newPerson.setFirstName(firstName);
			newPerson.setLastName(lastName);
			newPerson.setAddress("unknown");
			newPerson.setCity("unknown");
			newPerson.setState("unknown");
			newPerson.setZipcode(11790);
			
			
			// This will load the MySQL driver, each DB has its own driver
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				
				// Execute SQL query
				//Add Person
				DBUtils.insertPerson(connect, newPerson);
				// Insert new person info to BackUp Database 
				DBUtils.insertPerson(dao.getBackupConnection(), newPerson);
				

				
				// Execute SQL query
				EmployeeJude newEmployee = new EmployeeJude();
				newEmployee.setId(newPerson.getId());
				newEmployee.setSSN(SSN);
				newEmployee.setManager(isManager);
				newEmployee.setHourlyRate(hourlyRate);
				newEmployee.setUserName(userName);
				newEmployee.setPwd(pwd);
					
					
				DBUtils.insertEmployee(connect, newEmployee);
				// Insert new employee info to BackUp Database 
				DBUtils.insertEmployee(dao.getBackupConnection(), newEmployee);
					
				PrintWriter out= response.getWriter();
				out.println("<font color=green>Add successful, please check table.</font>");
					
				response.sendRedirect("view-employee");
					
				connect.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		}
	}

}

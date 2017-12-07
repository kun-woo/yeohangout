package yeohangout.servlet.dashboard.rep;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Person;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet(name = "add-customer-rep", urlPatterns = { "/add-customer-rep" })
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String creditCardNo = request.getParameter("creditCardNo");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String errorMsg = null;


		if (firstName == null || firstName.equals("")) {
			errorMsg = "Input Null";
		}
		if (lastName == null || lastName.equals("")) {
			errorMsg = "Input Null";
		}
		if (userName == null || userName.equals("")) {
			errorMsg = "Input Null";
		}
		if (pwd == null || pwd.equals("")) {
			errorMsg = "Input Null";
		}

		if (errorMsg != null){
			PrintWriter out= response.getWriter();
			out.println(errorMsg);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/dashboard-manager/dashboard-rep-overview.jsp");

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

				// Execute SQL query

				String sql = "Insert into howoo.customer(Id, CreditCardNo, CreationDate, Rating, UserName, Pwd) " 
	    				+ "values (?,?,now(),?,?,?)";
	    		
	    			PreparedStatement pstm = (PreparedStatement) connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    	   
	    			pstm.setInt(1, newPerson.getId());
	    			pstm.setString(2, creditCardNo);
	    			pstm.setInt(3, rating);
	    			pstm.setString(4, userName);
	    			pstm.setString(5, pwd);
	    		
	    			pstm.executeUpdate();
	    			pstm.close();
				// Insert new employee info to BackUp Database 

				response.sendRedirect("view-customer-rep");

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

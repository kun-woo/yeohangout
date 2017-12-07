package yeohangout.servlet.dashboard.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class EdistCustomerServlet
 */
@WebServlet(name = "edit-customer", urlPatterns = { "/edit-customer" })
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
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
		int keyCust = Integer.parseInt(request.getParameter("edited_cust"));
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

			// This will load the MySQL driver, each DB has its own driver
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();


				// Execute SQL query


				String sql = "UPDATE Customer SET CreditCardNo = ?, CreationDate = now(), Rating = ?, "
						+ "UserName = ?, Pwd = ? WHERE Customer.AccountNo = ?";	    		
	    			PreparedStatement pstm = (PreparedStatement) connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    	   
	    			pstm.setString(1, creditCardNo);
	    			pstm.setInt(2, rating);
	    			pstm.setString(3, userName);
	    			pstm.setString(4, pwd);
	    			pstm.setInt(5, keyCust);

	    			
	    			pstm.executeUpdate();
	    		
				// Insert new employee info to BackUp Database 

				response.sendRedirect("view-customer");

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

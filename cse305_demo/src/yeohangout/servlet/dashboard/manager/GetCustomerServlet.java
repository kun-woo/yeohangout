package yeohangout.servlet.dashboard.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class GetCustomerServlet
 */
@WebServlet(name = "view-customer", urlPatterns = { "/view-customer" })
public class GetCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerServlet() {
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
					ps = connect.prepareStatement("SELECT p.FirstName, p.LastName, e.AccountNo, e.CreditCardNo, e.CreationDate, "
							+ "e.Rating, e.UserName, e.Pwd "
							+ "FROM Customer e LEFT JOIN Person P ON p.Id = e.Id");
					rs = ps.executeQuery();
					
					ArrayList<Customer> custArr = new ArrayList<Customer>();

					if (rs != null) {
							while (rs.next()) {
								custArr.add(new Customer(rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("AccountNo"), rs.getString("CreditCardNo"), 
								rs.getTimestamp("CreationDate"), rs.getInt("Rating"), rs.getString("UserName"), rs.getString("Pwd")));
							}
							HttpSession session = request.getSession();
							session.setAttribute("custArr", custArr);
							String contextPath = request.getContextPath();
							response.sendRedirect(contextPath + "/dashboard-manager/dashboard-manager-user.jsp");
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

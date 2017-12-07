package yeohangout.servlet.dashboard.rep;

import java.io.IOException;
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

import yeohangout.javabeans.MailList;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class GetMailListServlet
 */
@WebServlet(name = "view-mail-list", urlPatterns = { "/view-mail-list" })
public class GetMailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMailListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();

			try {
				// Execute SQL query
				ps = connect.prepareStatement("SELECT * FROM CustMailList");
				rs = ps.executeQuery();

				ArrayList<MailList> mailArr = new ArrayList<MailList>();

				if (rs != null) {
					while (rs.next()) {
						mailArr.add(new MailList(rs.getString("Name"), rs.getInt("AccountNo"), rs.getString("Address"),
								rs.getString("Telephone"), rs.getString("Email")));
					}
					HttpSession session = request.getSession();
					session.setAttribute("mailArr", mailArr);
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath + "/dashboard-rep/dashboard-rep-mail.jsp");
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
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

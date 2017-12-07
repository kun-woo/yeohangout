package yeohangout.servlet.dashboard.rep;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet(name = "delete-customer-rep", urlPatterns = { "/delete-customer-rep" })
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int accountNo = Integer.parseInt(session.getAttribute("dash_delete_cust").toString());
		String errorMsg = null;

		if (accountNo == 0) {
			errorMsg = "Input 0";
		}

		if (errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}
		else {
			// This will load the MySQL driver, each DB has its own driver
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();

				try {
					// Execute SQL query
					ps = connect.prepareStatement("DELETE FROM Customer WHERE AccountNo = ?");
					ps.setInt(1, accountNo);
					ps.execute();


					PrintWriter out = response.getWriter();
					out.println("Delete successful, please check table.");

					response.sendRedirect("view-customer-rep");

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
			} catch (Exception e) {
				e.printStackTrace();
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

package yeohangout.servlet.dashboard.customer;

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

import yeohangout.javabeans.Auction;
import yeohangout.mysql.MySQLAccess;

/**
 * Servlet implementation class GetCustomerAuction
 */
@WebServlet(name = "get-customer-auction", urlPatterns = { "/get-customer-auction" })
public class GetCustomerAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;
	private ResultSet rs;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCustomerAuction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();

		int accountNO = Integer.parseInt(request.getParameter("userID"));
		ArrayList<Auction> aucArr = new ArrayList<Auction>();


		try {

			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();

			ps = connect.prepareStatement("SELECT * FROM Auction WHERE AccountNo = ?");
			ps.setInt(1, accountNO);
			rs = ps.executeQuery();


			if (rs != null) {
				while (rs.next()) {
					aucArr.add(new Auction(rs.getInt("AccountNo"), rs.getString("AirlineID"), rs.getInt("FlightNo"), rs.getString("Class"), 
							rs.getTimestamp("Date"), rs.getDouble("NYOP"), rs.getBoolean("Accepted")));
				}
				HttpSession session = request.getSession();
				session.setAttribute("aucArr", aucArr);
				session.setAttribute("accountNO", accountNO);

				response.sendRedirect(contextPath + "/dashboard-customer/dashboard-customer-auction.jsp");
				
				rs.close();
				ps.close();
				dao.close();

			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-manager/dashboard-manager-employee.jsp");
				System.out.println("No user found with given input, please register first.");
				rd.include(request, response);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.UserAccount;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;

/**
 * Servlet implementation class LoginServletTemp
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();

		String contextPath = request.getContextPath();

		String userId = request.getParameter("userID");
		String password = request.getParameter("password");
		
		boolean submitButtonPressed = request.getParameter("submitBt") != null;
		UserAccount loginedUser  = null;

		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();

			loginedUser = DBUtils.searchUser(connect, userId);
			
			dao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(loginedUser == null) {
			//go to the user is not existing page.
			System.out.println("NO USER");
			response.sendRedirect(contextPath + "/userNotFound.jsp");
			return;
		} else if (!loginedUser.getPassword().equals(password)){
			System.out.println("NOT MATCHED");
			//if the password is not matched.
			response.sendRedirect(contextPath+"/userNotFound.jsp");
		} else {
			HttpSession session = request.getSession(true);
			//store user into session and cookie
			MyUtils myUtil =  MyUtils.getMyUtils();
			
			MyUtils.storeLoginedUser(session, loginedUser);
			MyUtils.storeUserCookie(response, loginedUser);
			
			response.sendRedirect(contextPath+"/index.jsp");
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

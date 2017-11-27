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

import yeohangout.javabeans.Employee;
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
			
			
			if(loginedUser == null) {
				//go to the user is not existing page.
				//check employee if the user name is not in Customer table.
				Employee loginedEmployee = DBUtils.searchEmployee(connect, userId);
				//
				if(loginedEmployee ==null) {
					System.out.println("NO USER");
					response.sendRedirect(contextPath + "/userNotFound.jsp");
					return;
				}else if(!loginedEmployee.getPassword().equals(password)) {
					//the home page will be changed employee version
		
					System.out.println("Not matched");
					response.sendRedirect(contextPath+"/userNotFound.jsp");
					
				} else {
					System.out.println("here");
					HttpSession session = request.getSession(true);
					//store user into session and cookie
					MyUtils myUtil =  MyUtils.getMyUtils();
					
					MyUtils.storeLoginedUser(session, loginedEmployee);
					MyUtils.storeUserCookie(response, loginedEmployee);
					MyUtils.setUserType(1);
					response.sendRedirect(contextPath+"/index.jsp");
				}
				
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
				MyUtils.setUserType(0);
				
				response.sendRedirect(contextPath+"/index.jsp");
			} 
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

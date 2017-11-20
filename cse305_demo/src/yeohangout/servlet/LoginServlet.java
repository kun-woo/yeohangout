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


public class LoginServlet extends HttpServlet{
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		
		
		String contextPath = request.getContextPath();
		
		int id = Integer.parseInt(request.getParameter("userIDTF"));
	    boolean submitButtonPressed = request.getParameter("submitBt") != null;
	    UserAccount loginedUser  = null;
	    
	    //if(submitButtonPressed==true) {
	
	    	 	try {
	    	 		MySQLAccess dao = new MySQLAccess();
		    		dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				
				loginedUser = DBUtils.searchUser(connect, id);
				
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

	    			// ==> /ServletTutorial/showMe
	    			response.sendRedirect(contextPath + "/userNotFound.jsp");
	    			return;
		    		 
	    	 		   
	    	 	} else {
	    		    out.println("<body>");
	    		    out.println("<p> Hello, "+id+ "!!</p>");
	    		    out.println("<p> your account is  : "+loginedUser.getAccountNo()+"</p>");
	    	 	}
	    		
//	    }
//	    else {
//	    		
//	    }

	    	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
}

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
@WebServlet("/LoginServlet")
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

    	int id = Integer.parseInt(request.getParameter("userIDTF"));
    	boolean submitButtonPressed = request.getParameter("submitBt") != null;
    	UserAccount loginedUser  = null;


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
    		response.sendRedirect(contextPath + "/userNotFound.jsp");
    		return;
    	} else {
    		HttpSession session = request.getSession(true);
    		//store user into session and cookie
    		MyUtils.storeLoginedUser(session, loginedUser);
    		MyUtils.storeUserCookie(response, loginedUser);

    		out.println("<body>");
    		out.println("<p> Hello, "+MyUtils.getLoginedUser(session).getUserID()+ "!!!!!</p>");
    		out.println("<p> your account is  : "+loginedUser.getAccountNo()+"</p>");
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

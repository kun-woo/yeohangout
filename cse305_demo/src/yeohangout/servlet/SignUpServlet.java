package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Person;
import yeohangout.javabeans.UserAccount;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;

/**
 * Servlet implementation class SignUpServletTemp
 */

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SIGNUP PAGE");

		String contextPath = request.getContextPath();

		Person newPerson = new Person();
		UserAccount newUser = new UserAccount();

		String fName = request.getParameter("personFName");
		String lName = request.getParameter("personLName");
		String address = request.getParameter("personAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		int creditCardNo = Integer.parseInt(request.getParameter("creditCardNo"));
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());

		newPerson.setFirstName(fName);
		newPerson.setLastName(lName);
		newPerson.setAddress(address);
		newPerson.setCity(city);
		newPerson.setState(state);
		newPerson.setZipcode(zipcode);
		newPerson.setEmail(email);
		newPerson.setTelephone(telephone);
		

		newUser.setCreditCardNo(creditCardNo);
		newUser.setAccountCreationDate(currentDate);
		newUser.setRating(0);
		newUser.setUserID(userID);
		newUser.setPassword(password);


		boolean submitButtonPressed = request.getParameter("submitBt") != null;

		//Insert new user info to Database, This code will insert the sign up information into Person and Customer table.
		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			if(DBUtils.searchEmployee(connect, userID)==null && DBUtils.searchUser(connect, userID)==null) {
				DBUtils.insertPerson(connect, newPerson);
				newUser.setPersonID(newPerson.getId());
				DBUtils.insertUser(connect, newUser);
				
				// Insert new person and user info to BackUp Database 
				DBUtils.insertPerson(dao.getBackupConnection(), newPerson);
				DBUtils.insertUser(dao.getBackupConnection(), newUser);
			}else {
				MyUtils.setIdAlreadyExists(true);
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

		//Redirection to index.jsp
		
		response.sendRedirect(contextPath+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

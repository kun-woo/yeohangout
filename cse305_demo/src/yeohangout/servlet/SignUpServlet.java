package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Person;
import yeohangout.javabeans.UserAccount;
import yeohangout.mysql.DBUtils;
import yeohangout.mysql.MySQLAccess;

public class SignUpServlet extends HttpServlet{

	public SignUpServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
		
		String contextPath = request.getContextPath();
		
		Person newPerson = new Person();
		UserAccount newUser = new UserAccount();
		
		int id = Integer.parseInt(request.getParameter("personID"));
	    String fName = request.getParameter("personFName");
	    String lName = request.getParameter("personLName");
	    String address = request.getParameter("personAddress");
	    String city = request.getParameter("city");
	    String state = request.getParameter("state");
	    int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	    
	    int accountNo = Integer.parseInt(request.getParameter("accountNo"));
	    int creditCardNo = Integer.parseInt(request.getParameter("creditCardNo"));
	    Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
	    
	    
	    
	    newPerson.setId(id);
	    newPerson.setFirstName(fName);
	    newPerson.setLastName(lName);
	    newPerson.setAddress(address);
	    newPerson.setCity(city);
	    newPerson.setState(state);
	    newPerson.setZipcode(zipcode);
	    
	    newUser.setUserID(id);
	    newUser.setAccountNo(accountNo);
	    newUser.setCreditCardNo(creditCardNo);
	    newUser.setAccountCreationDate(currentDate);
	    newUser.setRating(0);
	    
	    
	    
	    
	    boolean submitButtonPressed = request.getParameter("submitBt") != null;
	    
	    try {
	    		MySQLAccess dao = new MySQLAccess();
	    		dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			DBUtils.insertPerson(connect, newPerson);
			DBUtils.insertUser(connect, newUser);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    if(submitButtonPressed==true) {
//	    		
//	    }
//	    else {
//	    	
//	    }
		
	    out.println("<html><head><title>SignUp</title></head>");
	    out.println("<body>");
	    out.println("<p> id : "+newPerson.getId()+"</p>");
	    out.println("<p> first name : "+newPerson.getFirstName()+"</p>");
	    out.println("<p> last name : "+newPerson.getLastName()+"</p>");
	    out.println("<p> address : "+newPerson.getAddress()+"</p>");
	    out.println("<p> city : "+ newPerson.getCity()+"</p>");
	    out.println("<p> state : "+ newPerson.getState()+"</p>");
	    out.println("<p> zipcode : "+newPerson.getZipcode()+"</p>");
	    out.println("</body>");
	    out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
}

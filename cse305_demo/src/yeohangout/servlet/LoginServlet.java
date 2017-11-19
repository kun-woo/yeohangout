package yeohangout.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
		
		String contextPath = request.getContextPath();
		
		String name = request.getParameter("userIDTF");
	    
	    boolean submitButtonPressed = request.getParameter("submitBt") != null;
	    
	    if(submitButtonPressed==true) {
	    		
	    }
	    else {
	    	
	    }
//    out.println("<html>");
//	    out.println("<head><title>wow</title></head>");
//	    out.println("<body>");
//	    out.println("<p> name : "+name+ "</p>");
//	    out.println("<p> password : "+pass+"</p>");
//	    out.println("</body></html>");
	    
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
}

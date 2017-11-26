package yeohangout.mysql;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String JDBC_DRIVER = "com.mysql.jdbcs.Driver"; 
		final String DB_URL = "jdbc:mysql://mysql2.cs.stonybrook.edu:3306/howoo";
		
		final String USER = "howoo";
		final String PASS = "111255764";
		
		// final String ;
		Connection connection;
		Statement statement;
		PrintWriter out;
		ResultSet rs;
		
		response.setContentType("text/html");
		
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);	
		statement = connection.createStatement();
		out = response.getWriter();
		
		rs = statement.executeQuery("SELECT ID, name FROM airport");
		
		out.println("<HTML><HEAD><TITLE>Products</TITLE></HEAD>");
	      out.println("<BODY>");
	      out.println("<UL>");

	      while (rs.next()) {
	        out.println("<LI>" + rs.getString("ID") + " "
	            + rs.getString("name"));
	      }

	      out.println("</UL>");
	      out.println("</BODY></HTML>");
		
		try {
			
		} catch (IOException ex) {
            ex.printStackTrace();
        } catch(SQLException e) {
        	e.printStackTrace();
        }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String s = request.getParameter("departure-airport");
		System.out.print("Departure: " + s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

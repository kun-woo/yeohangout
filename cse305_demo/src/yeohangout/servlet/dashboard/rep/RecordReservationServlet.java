package yeohangout.servlet.dashboard.rep;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Passenger;
import yeohangout.javabeans.Person;
import yeohangout.mysql.DBUtils;

/**
 * Servlet implementation class RecordReservationServlet
 */
@WebServlet(name = "record-reservation", urlPatterns = { "/record-reservation" })
public class RecordReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String passName = request.getParameter("passName");
		int resrNo = Integer.parseInt(request.getParameter("resrNo"));
		Timestamp resrDate = Timestamp.valueOf(request.getParameter("rserDate"));
		double bookingFee = Double.parseDouble(request.getParameter("bookingFee"));
		double totalFare = Double.parseDouble(request.getParameter("totalFare"));
		int repSSN = Integer.parseInt(request.getParameter("repSSN"));
		String airlineID = request.getParameter("airlineID");
		int flightNo = Integer.parseInt(request.getParameter("flightNo"));
		int legNo = Integer.parseInt(request.getParameter("legNo"));
		int seatNo = Integer.parseInt(request.getParameter("seatNo"));
		String cabinClass = request.getParameter("class");
		String meal = request.getParameter("meal");
		PreparedStatement pstm = null;
		
		String errorMsg = null;
		
		if (passName == null || passName.equals("")) {
			errorMsg = "Input Null";
		}
		
		if (errorMsg != null){
			PrintWriter out= response.getWriter();
			out.println(errorMsg);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/dashboard-manager/dashboard-rep-overview.jsp");
			
		}
		else {
			
			//make person object
			Person newPerson = new Person();
			
			newPerson.setFirstName(passName);
			newPerson.setLastName(passName);
			newPerson.setAddress("unknown");
			newPerson.setCity("unknown");
			newPerson.setState("unknown");
			newPerson.setZipcode(11790);
			
			
			// Execute SQL query
			Passenger newPassenger = new Passenger();
			
			
			// This will load the MySQL driver, each DB has its own driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Setup the connection with the DB
				Connection connect = DriverManager
						.getConnection("jdbc:mysql://mysql2.cs.stonybrook.edu:3306/howoo?"
								+ "user=howoo&password=111255764");
					// Execute SQL query
					
					try {
						//Add Person
						DBUtils.insertPerson(connect, newPerson);
						newPassenger.setId(newPerson.getId());

						
						String sql = "Insert into howoo.Passenger (Id,AccountNo)"
					       		+ "values (?,?)";
					        pstm = (PreparedStatement) connect.prepareStatement(sql);
					       
					       pstm.setInt(1, newPassenger.getId());
					       pstm.setInt(2, 3);
					       pstm.executeUpdate();
						
						
						System.out.println("Recorded\n");
					} finally {
						pstm.close();
					}
					
					try {
						//Add Reservation						
						
						String sql = "Insert into howoo.Reservation (ResrNo,ResrDate,BookingFee,TotalFare,RepSSN,AccountNo)"
					       		+ "values (?,?,?,?,?,?)";
					        pstm = (PreparedStatement) connect.prepareStatement(sql);
					       
					       pstm.setInt(1, resrNo);
					       pstm.setTimestamp(2, resrDate);
					       pstm.setDouble(3, bookingFee);
					       pstm.setDouble(4, totalFare);
					       pstm.setInt(5, repSSN);
					       pstm.setInt(6, 3);
					       pstm.executeUpdate();
						
						
						System.out.println("Recorded\n");
					} finally {
						pstm.close();
					}
					
					try {
																		
						String sql = "Insert into howoo.Includes (ResrNo,AirlineID,FlightNo,LegNo,ResrDate)"
					       		+ "values (?,?,?,?,?)";
					        pstm = (PreparedStatement) connect.prepareStatement(sql);
					       
					        pstm.setInt(1, resrNo);
						    pstm.setString(2, airlineID);
						    pstm.setDouble(3, flightNo);
						    pstm.setDouble(4, legNo);
						    pstm.setTimestamp(5, resrDate);
						    pstm.executeUpdate();
						
						
						System.out.println("Recorded\n");
					} finally {
						pstm.close();
					}
					
					try {
						
						String sql = "Insert into howoo.ReservationPassenger (ResrNo,Id,AccountNo,SeatNo,Class,Meal)"
					       		+ "values (?,?,?,?,?)";
					        pstm = (PreparedStatement) connect.prepareStatement(sql);
					       
					        pstm.setInt(1, resrNo);
						    pstm.setInt(2, newPassenger.getId());
						    pstm.setDouble(3, 3);
						    pstm.setDouble(4, seatNo);
						    pstm.setString(5, cabinClass);
						    pstm.setString(6, meal);
						    pstm.executeUpdate();
						
						
						System.out.println("Recorded\n");
					} finally {
						pstm.close();
					}
					
					response.sendRedirect("record-reservation");
					
					connect.close();

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}

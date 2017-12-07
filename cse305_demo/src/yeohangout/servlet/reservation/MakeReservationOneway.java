package yeohangout.servlet.reservation;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.LegFlightAirport;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;
import yeohangout.mysql.SingletonForMulticity;

@WebServlet(name = "makeReservation", urlPatterns = {"/makeReservation"})
public class MakeReservationOneway extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeReservationOneway() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		
		
		
		String airlineID = request.getParameter("airlineID");
		int flightNo = Integer.parseInt( request.getParameter("flightNO"));
		int legNO = Integer.parseInt(request.getParameter("legNO"));
		String travleType = request.getParameter("travelType");
		
		
		LegFlightAirport result = null;
		LegFlightAirport backResult = null;
		
		if(MyUtils.getUserType()==0) {
			
			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
				Connection connect = null;
				connect = dao.getConnection();
				Leg selectedLeg = AirlineUtils.searchLeg(connect, airlineID, flightNo, legNO);
				Airport depAirport = AirlineUtils.searchAirport(connect, selectedLeg.getDepAirportID());
				Airport arrAirport = AirlineUtils.searchAirport(connect, selectedLeg.getArrAirportID());
				result= 	new LegFlightAirport(selectedLeg);
				
				result.setDepAirport(depAirport);
				result.setArrAirport(arrAirport);
				
				if(travleType.equals("R")) {
					

					String airlineID2 = request.getParameter("airlineID2");
					int flightNo2 = Integer.parseInt( request.getParameter("flightNO2"));
					int legNO2 = Integer.parseInt(request.getParameter("legNO2"));
					
					Leg selectedLeg2 = AirlineUtils.searchLeg(connect, airlineID2, flightNo2, legNO2);
					Airport depAirport2 = AirlineUtils.searchAirport(connect, selectedLeg2.getDepAirportID());
					Airport arrAirport2 = AirlineUtils.searchAirport(connect, selectedLeg2.getArrAirportID());
					backResult= 	new LegFlightAirport(selectedLeg2);
					
					backResult.setDepAirport(depAirport2);
					backResult.setArrAirport(arrAirport2);
				}
				
				
				dao.close();
				
			} catch(Exception ex){
				ex.printStackTrace();
			}
			
			request.setAttribute("result_resrv", result);		//send data from servlet to jsp
			
			RequestDispatcher rd = null;
			
			if(travleType.equals("R")) {
				
				request.setAttribute("result_back_resrv", backResult);
				rd = request.getRequestDispatcher("/home-search/search-summary-round.jsp");
				
			}else {
				
				rd = request.getRequestDispatcher("/home-search/search-summary.jsp");
				
			}
			
			rd.forward(request, response);
			
		}else {
			response.sendRedirect(contextPath+"/userNotFound.jsp");
			
		}
		//NEXT 
		
	}
	

}

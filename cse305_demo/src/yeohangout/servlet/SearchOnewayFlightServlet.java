package yeohangout.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.LegFlightAirport;
import yeohangout.mysql.AirlineUtils;
import yeohangout.mysql.AirportUtils;
import yeohangout.mysql.FareUtils;
import yeohangout.mysql.FlightSearchUtils;
import yeohangout.mysql.MySQLAccess;
import yeohangout.mysql.MyUtils;
import yeohangout.mysql.SingletonForMulticity;

@WebServlet(name = "searchOneway", urlPatterns= {"/searchOneway"})
public class SearchOnewayFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SearchOnewayFlightServlet() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();
		
		String depCity = request.getParameter("depCity");
		String depCountry = request.getParameter("depCountry");
		String depTimeString = request.getParameter("depTime");
		
		String arrCity = request.getParameter("arrCity");
		String arrCountry = request.getParameter("arrCountry");
		String buttonType = request.getParameter("type_btn");
//		System.out.println(" Wong ");
//		
//		System.out.println(" :" +request.getParameter("auc_btn"));
//	
		String auction = request.getParameter("auc_btn");
//		System.out.println(" Ma ");
		
		
		Date depTime  =null;	
		Date returnTime = null;
	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy"); 
		
		boolean auctionFlag = false;
		
		if (auction.equals("normal")) {
			auctionFlag = false;
		}
		else {
			auctionFlag = true;
		}
		
		
		try {
			depTime = (java.util.Date)df.parse(depTimeString);
			
			if(buttonType.equals("round-trip")) {
				
				String retTimeString = request.getParameter("returnTime");
				
				returnTime = (java.util.Date) df2.parse(retTimeString);
			}
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		ArrayList<LegFlightAirport> searchedLegs = new ArrayList<LegFlightAirport>();
		
		//for round-trip
		ArrayList<LegFlightAirport> searchedLegsBack = new ArrayList<LegFlightAirport>();
		
		//for multi city
		ArrayList<LegFlightAirport> secondLegs = new ArrayList<LegFlightAirport>();
		ArrayList<LegFlightAirport> thirdLegs = new ArrayList<LegFlightAirport>();
		
		
		
		
		MySQLAccess dao = null;
		
		
		try {
			dao = new MySQLAccess();
			dao.readDataBase();
			Connection connect = null;
			connect = dao.getConnection();
			
			Airport searchedDepAirport = AirportUtils.searchAirportByCityCountry(connect, depCity, depCountry);
			Airport searchedArrAirport = AirportUtils.searchAirportByCityCountry(connect, arrCity, arrCountry);
			
			if(buttonType.equals("one-way")) {
				//one way
			
				if(searchedDepAirport!=null && searchedArrAirport!=null) {
					
					searchedLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedDepAirport.getID(), searchedArrAirport.getID(), depTime);
					
					
				}else {
					//Error
					
				}
			
			}else if(buttonType.equals("round-trip")) {
				System.out.println("Round Trip");
				
				if(searchedDepAirport!=null && searchedArrAirport!=null) {
					
					searchedLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedDepAirport.getID(), searchedArrAirport.getID(), depTime);
					searchedLegsBack = FlightSearchUtils.searchFlightByAirport(connect, searchedArrAirport.getID(), searchedDepAirport.getID(), returnTime);
				}else {
					//Error
					
				}
				
			}else {
				System.out.println("Multi");
				
				SingletonForMulticity.clearSingleton();
				
				SingletonForMulticity sfmc = SingletonForMulticity.getSingletonForMulticity();
				
				String depCity2 = request.getParameter("arrCity");
				String depCountry2 = request.getParameter("arrCountry");
				String depTimeString2 = request.getParameter("depTime2");
				String arrCity2 = request.getParameter("arrCity2");
				String arrCountry2 = request.getParameter("arrCountry2");
				Airport searchedSecDepAirport = AirportUtils.searchAirportByCityCountry(connect, depCity2, depCountry2);
				Airport searchedSecArrAirport = AirportUtils.searchAirportByCityCountry(connect, arrCity2, arrCountry2);
				Date depTime2 = (java.util.Date) df2.parse(depTimeString2);
				
				
				String depCity3 = request.getParameter("arrCity2");
				String depCountry3 = request.getParameter("arrCountry2");
				String depTimeString3 = request.getParameter("depTime3");
				String arrCity3 = request.getParameter("arrCity3");
				String arrCountry3 = request.getParameter("arrCountry3");
				Airport searchedThirdDepAirport = AirportUtils.searchAirportByCityCountry(connect, depCity3, depCountry3);
				Airport searchedThirdArrAirport = AirportUtils.searchAirportByCityCountry(connect, arrCity3, arrCountry3);
				Date depTime3 = (java.util.Date) df2.parse(depTimeString3);
				
				searchedLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedDepAirport.getID(), searchedArrAirport.getID(), depTime);
				sfmc.setFirstLegs(searchedLegs);
				
				if(searchedLegs.size()>0) {
					SingletonForMulticity.setValid(true);
				}
				
				secondLegs = FlightSearchUtils.searchFlightByAirport(connect, searchedSecDepAirport.getID(), searchedSecArrAirport.getID(), depTime2);
				
				if(secondLegs.size()>0) {
					sfmc.setSecondLegs(secondLegs);
				}
				
			
				thirdLegs =  FlightSearchUtils.searchFlightByAirport(connect, searchedThirdDepAirport.getID(), searchedThirdArrAirport.getID(), depTime3);
				
				if(thirdLegs.size()>0) {
					sfmc.setThirdLegs(thirdLegs);
				}
			}
			
			for(LegFlightAirport searchLeg : searchedLegs) {
				searchLeg.setFare(FareUtils.searchFare(connect, searchLeg.getLeg().getAirlineID(), searchLeg.getLeg().getFlightNo()));
			}
			
			if(buttonType.equals("round-trip")){
				for(LegFlightAirport searchLeg : searchedLegsBack ) {
					searchLeg.setFare(FareUtils.searchFare(connect, searchLeg.getLeg().getAirlineID(), searchLeg.getLeg().getFlightNo()));
				}
			}
			
			if(buttonType.equals("multi-city")) {
				if(secondLegs.size()>0) {
					for(LegFlightAirport searchLeg : secondLegs) 
						searchLeg.setFare(FareUtils.searchFare(connect, searchLeg.getLeg().getAirlineID(), searchLeg.getLeg().getFlightNo()));
					
				}
				if(thirdLegs.size()>0) {
					for(LegFlightAirport searchLeg : thirdLegs) 
						searchLeg.setFare(FareUtils.searchFare(connect, searchLeg.getLeg().getAirlineID(), searchLeg.getLeg().getFlightNo()));
				}
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.close();
		}
		
		
		
		
		
		request.setAttribute("searchLegs", searchedLegs);
		RequestDispatcher rd =null;
		
		if(buttonType.equals("one-way")) {
			rd = request.getRequestDispatcher("home-search/search-result.jsp");
		}else if(buttonType.equals("round-trip")) {
			request.setAttribute("backLegs", searchedLegsBack);
			rd = request.getRequestDispatcher("home-search/search-result-round.jsp");
		}else {
//			request.setAttribute("secondLegs", secondLegs);
//			request.setAttribute("thirdLegs", thirdLegs);
			rd = request.getRequestDispatcher("home-search/search-result-multi.jsp");
		}
		System.out.println("Dang" + auctionFlag);
		if(auctionFlag) {
			rd = request.getRequestDispatcher("home-search/search-result-auction.jsp");
		}
		
		rd.forward(request, response);
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

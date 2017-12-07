package yeohangout.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airline;
import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Flight;
import yeohangout.javabeans.IncludeAndLeg;
import yeohangout.javabeans.Leg;

public class AirlineUtils {
	
	 public static void insertAirline(Connection conn, Airline airline) throws SQLException {
 		String sql = "Insert into howoo.airline(Id, Name)"
 				+ "values (?,?)";
 		
 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 	   
 		pstm.setString(1, airline.getArirlineID());
 		pstm.setString(2, airline.getAirlineName());
 		
 		pstm.executeUpdate();
	 }
 	    
	 
	 public static Airline searchAirline(Connection conn, String airlineId) throws SQLException{
	 		
	 		String sql = "Select * FROM howoo.airline a Where a.id = ?";
	 		
	 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
	 		
	 		pstm.setString(1, airlineId);
	 		
	 		ResultSet rs = pstm.executeQuery();
	
	 		while(rs.next()) {
	 			Airline searchedAirline = new Airline();
	 			
	 			searchedAirline.setArirlineID(rs.getString("Id"));
	 			searchedAirline.setAirlineName(rs.getString("Name"));
	
	 			return searchedAirline;
	 		}
	 		return null;
	
	 }
	 
	 public static void insertFlight(Connection conn, Flight flight) throws SQLException {
	 		String sql = "Insert into howoo.flight(AirlineID, FlightNo, NoOfSeats, DaysOperating, MinLengthOfStay,MaxLengthOfStay )"
	 				+ "values (?,?,?,?,?,?)";
	 		
	 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
	 	   
	 		pstm.setString(1, flight.getAirlineID());
	 		pstm.setInt(2, flight.getFlightNumber());
	 		pstm.setInt(3,  flight.getNumberOfSeats());
	 		pstm.setString(4, flight.getDaysOperating());
	 		pstm.setInt(5, flight.getMinLenStay());
	 		pstm.setInt(6, flight.getMaxLenStay());
	 		
	 		pstm.executeUpdate();
		 }
	 	    
		 
		 public static Flight searchFlight(Connection conn, String airlineId, int flightNo) throws SQLException{
		 		
		 		String sql = "Select * FROM howoo.flight f Where f.AirlineId = ? AND f.FlightNo = ?";
		 		
		 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		 		
		 		pstm.setString(1, airlineId);
		 		pstm.setInt(2, flightNo);
		 		
		 		ResultSet rs = pstm.executeQuery();
		
		 		while(rs.next()) {
		 			Flight searchedFlight = new Flight();
		 			
		 			searchedFlight.setAirlineID(rs.getString("AirlineID"));
		 			searchedFlight.setFlightNumber(rs.getInt("FlightNo"));
		 			searchedFlight.setNumberOfSeats(rs.getInt("noOfSeats"));
		 			searchedFlight.setDaysOperating(rs.getString("DaysOperating"));
		 			searchedFlight.setMinLenStay(rs.getInt("MinLengthOfStay"));
		 			searchedFlight.setMaxLenStay(rs.getInt("MaxLengthOfStay"));
		
		 			return searchedFlight;
		 		}
		 		return null;
		
		 }
		 
		 public static void insertAirport(Connection conn, Airport airport) throws SQLException {
		 		String sql = "Insert into howoo.airport(Id, Name, city, country)"
		 				+ "values (?,?,?,?)";
		 		
		 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		 		
		 		pstm.setString(1, airport.getID());
		 		pstm.setString(2, airport.getName());
		 		pstm.setString(3, airport.getCity());
		 		pstm.setString(4,  airport.getCountry());
		 		
		 		pstm.executeUpdate();
			 
		 }
		 	    
			 
			 public static Airport searchAirport(Connection conn, String airportID) throws SQLException{
			 		
			 		String sql = "Select * FROM howoo.airport a Where a.id = ?";
			 		
			 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			 		
			 		pstm.setString(1, airportID);
			 		
			 		ResultSet rs = pstm.executeQuery();
			
			 		while(rs.next()) {
			 			Airport searchedAirport = new Airport();
			 			
			 			searchedAirport.setID(rs.getString("Id"));
			 			searchedAirport.setName(rs.getString("Name"));
			 			searchedAirport.setCity(rs.getString("city"));
			 			searchedAirport.setCountry(rs.getString("country"));
			 			System.out.println("airport ID"+airportID);
			 			return searchedAirport;
			 		}
			 		System.out.println("airport ID"+null);
			 		return null;
			
			 }


			public static Leg searchLeg(Connection conn, String airlineId, int flightNumber, int legNo) throws SQLException{
				String sql = "Select * FROM howoo.leg l Where l.AirlineID = ? AND l.FlightNo = ? AND l.LegNo = ?";
				
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		 		
		 		pstm.setString(1, airlineId);
		 		pstm.setInt(2, flightNumber);
		 		pstm.setInt(3, legNo);
		 		
		 		ResultSet rs = pstm.executeQuery();
		 		
		 		while(rs.next()) {
		 			Leg searchedLeg = new Leg();
		 			
		 			searchedLeg.setAirlineID(rs.getString("airlineID"));
		 			searchedLeg.setFlightNo(rs.getInt("flightNo"));
		 			searchedLeg.setLegNo(rs.getInt("LegNo"));
		 			searchedLeg.setDepAirportID(rs.getString("DepAirportID"));
		 			searchedLeg.setArrAirportID(rs.getString("ArrAirportID"));
		 			searchedLeg.setDepDate(new java.util.Date(rs.getDate("DepTime").getTime()));
		 			searchedLeg.setArrDate(new java.util.Date(rs.getDate("ArrTime").getTime()));
		 			
		 			return searchedLeg;
		 		}
		 		
				return null;
			}

			public static void insertLeg(Connection conn, Leg newLeg) throws SQLException {
				String sql = "Insert into howoo.leg(AirlineID, FlightNo, LegNo, DepAirportID, ArrAirportID, DepTime, ArrTime)"
		 				+ "values (?,?,?,?, ?, ?, ?)";
		 		
		 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		 		
		 		pstm.setString(1, newLeg.getAirlineID());
		 		pstm.setInt(2, newLeg.getFlightNo());
		 		pstm.setInt(3, newLeg.getLegNo());
		 		pstm.setString(4,  newLeg.getDepAirportID());
		 		pstm.setString(5,  newLeg.getArrAirportID());
		 		pstm.setDate(6, new java.sql.Date(newLeg.getArrDate().getTime()));
		 		pstm.setDate(7,  new java.sql.Date(newLeg.getDepDate().getTime()));
		 		
		 		pstm.executeUpdate();
			}
			
			 public static ArrayList<Leg> searchFlightByUserID(Connection conn, int accountNo) throws SQLException{
				 ArrayList<Leg> legs = new ArrayList<Leg>();
				 String sql = "SELECT * "+
				 		 "FROM howoo.reservation r, howoo.includes i,  howoo.leg l, howoo.leg l2 "+
						 "WHERE r.AccountNo = ? AND i.ResrNo = r.ResrNo "+
						 "AND i.AirlineID = l.AirlineID AND i.flightNO = l.flightNO AND i.LegNO = l.LegNo "+
						 "AND l.ArrAirportID = l2.ArrAirportID";
				 
				 PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				 pstm.setInt(1, accountNo);
				 
				 ResultSet rs = pstm.executeQuery();
			 		
				 while(rs.next()) {
			 			Leg searchedLeg = new Leg();
			 			
			 			searchedLeg.setAirlineID(rs.getString("l2.airlineID"));
			 			searchedLeg.setFlightNo(rs.getInt("l2.flightNo"));
			 			searchedLeg.setLegNo(rs.getInt("l2.LegNo"));
			 			searchedLeg.setDepAirportID(rs.getString("l2.DepAirportID"));
			 			searchedLeg.setArrAirportID(rs.getString("l2.ArrAirportID"));
			 			searchedLeg.setDepDate(new java.util.Date(rs.getDate("l2.DepTime").getTime()));
			 			searchedLeg.setArrDate(new java.util.Date(rs.getDate("l2.ArrTime").getTime()));
			 		
			 			legs.add(searchedLeg);
			 	}
				 
				 return legs;
			
			 }
			 
			 
			 public static ArrayList<Flight> searchFlighSuggestionBasedOnBestSeller(Connection conn, int accountNo) throws SQLException{
				 ArrayList<Flight> flights = new ArrayList();
				 String sql = "Select * FROM howoo.bestflight bf"
				 		+ ", howoo.includes i, howoo.reservation r "
						 +"WHERE bf.airlineID = i.airlineID AND bf.flightNO = i.flightNO "
						 +"AND i.ResrNO = r.ResrNO AND r.accountNO != ?";
				 PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				 pstm.setInt(1, accountNo);
				 
				 ResultSet rs = pstm.executeQuery();
			 		
				 while(rs.next()) {
			 			Flight searchedFlight = new Flight();
			 			
			 			searchedFlight.setAirlineID(rs.getString("bf.airlineID"));
			 			searchedFlight.setFlightNumber(rs.getInt("bf.flightNo"));
			 			searchedFlight.setDaysOperating(rs.getString("bf.DaysOperating"));
			 			searchedFlight.setMinLenStay(rs.getInt("bf.MinLengthOfStay"));
			 			searchedFlight.setMaxLenStay(rs.getInt("bf.MaxLengthOfStay"));
			 		
			 			flights.add(searchedFlight);
			 	}
				 
				 return flights;
			 }
}

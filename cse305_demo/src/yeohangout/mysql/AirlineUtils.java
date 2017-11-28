package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airline;
import yeohangout.javabeans.Flight;

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
}

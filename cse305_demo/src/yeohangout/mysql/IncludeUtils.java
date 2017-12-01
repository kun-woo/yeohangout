package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.IncludeAndLeg;
import yeohangout.javabeans.Includes;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.Reservation;

public class IncludeUtils {
	
	public static void insertInclude(Connection conn, Includes includes) throws SQLException {
 		String sql = "Insert into howoo.includes(ResrNo, AirlineID, FlightNo, LegNo, Date)"
 				+ "values (?,?,?,?,?)";
 		
 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
 		
 		pstm.setInt(1, includes.getLegNo());
 		pstm.setString(2, includes.getAirlineID());
 		pstm.setInt(3, includes.getFlightNo());
 		pstm.setInt(4, includes.getLegNo());
 		pstm.setDate(5, new java.sql.Date(includes.getDate().getTime()));
 		
 		pstm.executeUpdate();
 	
	}
	
	 public static ArrayList<Includes> searchIncludesByResrNo(Connection conn, int resrNo) throws SQLException{
		    ArrayList<Includes> includes = new ArrayList<Includes>();
	 		
	 		String sql = "Select * FROM howoo.includes i Where i.ResrNo = ?";
	 		
	 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
	 		
	 		pstm.setInt(1, resrNo);
	 		
	 		ResultSet rs = pstm.executeQuery();
	
	 		while(rs.next()) {
	 			Includes searchedIncludes = new Includes();

	 			searchedIncludes.setResrNo(rs.getInt("ResrNo"));
	 			searchedIncludes.setAirlineID(rs.getString("AirlineID"));
	 			searchedIncludes.setFlightNo(rs.getInt("flightNo"));
	 			searchedIncludes.setLegNo(rs.getInt("LegNo"));
	 			searchedIncludes.setDate(new java.util.Date(rs.getDate("Date").getTime()));
	 			
	 			includes.add(searchedIncludes);
	 		
	 		}
	 		
	 		return includes;
	 }
	 
	 public static ArrayList<IncludeAndLeg> searchIncludesAndLegByResrNo(Connection conn, int resrNo, boolean checkCurrent) throws SQLException{
		 ArrayList<IncludeAndLeg> includes = new ArrayList<IncludeAndLeg>();
	 		
	 	String sql = "Select * "+
	 				"FROM howoo.includes i, howoo.leg l "+
	 				"Where i.ResrNo = ? "+
	 				"AND i.airlineID = l.airlineID "+
	 				"AND i.flightNo = l.flightNo "+
	 				"AND i.legNo = l.legNo";
	 	
 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
	 		
	 	pstm.setInt(1, resrNo);
	 		
	 	ResultSet rs = pstm.executeQuery();
	
	 	while(rs.next()) {
 			Includes searchedIncludes = new Includes();
 			
 			searchedIncludes.setResrNo(rs.getInt("ResrNo"));
 			searchedIncludes.setAirlineID(rs.getString("AirlineID"));
 			searchedIncludes.setFlightNo(rs.getInt("flightNo"));
 			searchedIncludes.setLegNo(rs.getInt("LegNo"));
 			searchedIncludes.setDate(new java.util.Date(rs.getDate("Date").getTime()));
 			
 			Leg searchedLeg = new Leg();
 			
 			searchedLeg.setAirlineID(rs.getString("airlineID"));
 			searchedLeg.setFlightNo(rs.getInt("flightNo"));
 			searchedLeg.setLegNo(rs.getInt("LegNo"));
 			searchedLeg.setDepAirportID(rs.getString("DepAirportID"));
 			searchedLeg.setArrAirportID(rs.getString("ArrAirportID"));
 			searchedLeg.setDepDate(new java.util.Date(rs.getDate("DepTime").getTime()));
 			searchedLeg.setArrDate(new java.util.Date(rs.getDate("ArrTime").getTime()));
 			
 			
 			IncludeAndLeg includeAndLeg = new IncludeAndLeg(searchedIncludes, searchedLeg);
 			if(checkCurrent) {											//This if statemet is for checking current Reserv
 				System.out.println("current Date : "+new Date()+"searched Date : "+searchedLeg.getDepDate());
 				if(searchedLeg.getDepDate().compareTo(new Date())>0) {	//if the depart date is before the current Date, the itinerary doesn't be contained in the array list 
 					includes.add(includeAndLeg);
 				}
 			}
 			else {
 				includes.add(includeAndLeg);
 			}
 		}	
	 	
	 	return includes;
	 }
}

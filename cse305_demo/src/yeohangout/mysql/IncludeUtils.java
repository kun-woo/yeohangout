package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Includes;
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
		    System.out.println("HERE " +resrNo);
	 		ArrayList<Includes> includes = new ArrayList<Includes>();
	 		
	 		String sql = "Select * FROM howoo.includes i Where i.ResrNo = ?";
	 		
	 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
	 		
	 		pstm.setInt(1, resrNo);
	 		
	 		ResultSet rs = pstm.executeQuery();
	
	 		while(rs.next()) {
	 			Reservation searchedReservation = new Reservation();
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
}

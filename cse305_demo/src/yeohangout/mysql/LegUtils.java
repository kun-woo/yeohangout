package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.Leg;

public class LegUtils {
	
	public static ArrayList<Leg> searchLeg(Connection conn, Airport depAirport, Airport arrAirport, String depTime, String arrTime) throws SQLException{
		
		String sql;		
		
		// Convert dates from MM/DD/YYYY to YYYY-MM-DD
		
		String depDate = convertDate(depTime);
		String arrDate = convertDate(arrTime);
		
		ArrayList<Leg> validLegs = new ArrayList<Leg>();
		
		PreparedStatement pstm;
		ResultSet rs;
		
		sql = 	  "SELECT * "
				+ "FROM howoo.leg l "
				+ "WHERE l.DepAirportID = ? AND l.ArrAirportID = ? "
				+ "AND DATE(l.ArrTime) = ? AND DATE(l.DepTime) = ?";
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
	
		pstm.setString(1, depAirport.getID());
		pstm.setString(2, arrAirport.getID());
		pstm.setString(3, depDate);
		pstm.setString(4, arrDate);
	
		rs = pstm.executeQuery();
	
		while(rs.next()) {
			Leg currLeg = new Leg();
			currLeg.setAirlineID(rs.getString("AirlineID"));
			currLeg.setFlightNo(rs.getInt("FlightNo"));
			currLeg.setLegNo(rs.getInt("LegNo"));
			currLeg.setDepAirportID(rs.getString("DepAirportID"));
			currLeg.setArrAirportID(rs.getString("ArrAirportID"));
			currLeg.setDepDate(rs.getDate("DepTime"));
			currLeg.setArrDate(rs.getDate("ArrTime"));
			
			
			validLegs.add(currLeg);
		}


		return validLegs;

}
	// Convert dates from MM/DD/YYYY to YYYY-MM-DD
	public static String convertDate(String originalDate) {
		
		String newDate = "";
		
		newDate = originalDate.substring(6, 10) + "-" 
				+ originalDate.substring(0, 2) + "-" 
				+ originalDate.substring(3, 5);

		return newDate;
	}
	 


}
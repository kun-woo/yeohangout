package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Fare;
import yeohangout.javabeans.Leg;

public class FareUtils {
	public static Fare searchFare(Connection conn, String airlineId, int flightNumber) throws SQLException{
		String sql = "Select * FROM howoo.fare f Where f.AirlineID = ? AND f.FlightNo = ?";
		
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 		
 		pstm.setString(1, airlineId);
 		pstm.setInt(2, flightNumber);
 		
 		ResultSet rs = pstm.executeQuery();
 		
 		while(rs.next()) {
 			Fare searchedFare = new Fare();
 			
 			searchedFare.setAirlineID(rs.getString("airlineID"));
 			searchedFare.setFlightNO(rs.getInt("flightNo"));
 			searchedFare.setFareType(rs.getString("fareType"));
 			searchedFare.setFare(rs.getDouble("fare"));
 			searchedFare.setClassType(rs.getString("class"));
 			searchedFare.setFlexible(rs.getBoolean("isFlexible"));
 			searchedFare.setDomestic(rs.getBoolean("isDomestic"));
 			
 			rs.close();
 			pstm.close();
 			return searchedFare;
 		}
 		

			rs.close();
			pstm.close();
 		
		return null;
	}
}

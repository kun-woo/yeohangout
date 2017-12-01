package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airport;

public class AirportUtils {
	
	public static ArrayList<Airport> searchAirport(Connection conn, String city, String country) throws SQLException {
		
		String sql;
		ArrayList<Airport> airportArray = new ArrayList<>();
		
		PreparedStatement pstm;
		ResultSet rs;
		
		sql =     "SELECT * "
				+ "FROM howoo.airport a "
				+ "WHERE a.City = ? AND a.Country = ?";
		
		try {
			pstm = (PreparedStatement) conn.prepareStatement(sql);
		
			pstm.setString(1, city);
			pstm.setString(2, country);
			System.out.println("\tCITY : " + city);
			System.out.println("\tCOUNTRY : " + country);
		
			rs = pstm.executeQuery();
		
			while(rs.next()) {
				Airport currAirport = new Airport();
				currAirport.setID(rs.getString("Id"));
				currAirport.setName(rs.getString("Name"));
				currAirport.setCity(rs.getString("City"));
				currAirport.setCountry(rs.getString("Country"));
			
				System.out.println("\tAIRPORT : " + currAirport.getName());
				airportArray.add(currAirport);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airportArray;
	}

	
}
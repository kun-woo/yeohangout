package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.EmployeeJude;
import yeohangout.javabeans.Leg;

public class FlightSearchUtils {
	
	public static ArrayList<Leg> searchFlightByAirport(Connection conn, String depAirport, String arrAirport, Date depDate) throws SQLException{
			ArrayList<Leg> legs = new ArrayList<Leg>();
			
			//String sql = "SELECT l.AirlineID, l.FlightNo, l.LegNo, l.DepAirportID, l.ArrAirportID, l.ArrTime, l.DepTime "+
			String sql = "Select * From howoo.leg l Where l.depAirportID = ? AND l.arrAirportID = ? AND depTime>=?";		
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, depAirport);
			ps.setString(2, arrAirport);
			ps.setDate(3, new java.sql.Date(depDate.getTime()));
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Leg newLeg = new Leg();
				newLeg.setAirlineID(rs.getString("airlineID"));
				newLeg.setFlightNo(rs.getInt("flightNo"));
				newLeg.setLegNo(rs.getInt("legNo"));
				newLeg.setDepAirportID(rs.getString("depAirportID"));
				newLeg.setArrAirportID(rs.getString("arrAirportID"));
				newLeg.setDepDate(new java.util.Date(rs.getDate("depTime").getTime()));
				newLeg.setArrDate(new java.util.Date(rs.getDate("arrTime").getTime()));
				
				legs.add(newLeg);
			}
			
			ps.close();
			
			return legs;
	    }
}

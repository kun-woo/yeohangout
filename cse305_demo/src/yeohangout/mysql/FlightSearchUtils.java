package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airport;
import yeohangout.javabeans.EmployeeJude;
import yeohangout.javabeans.Flight;
import yeohangout.javabeans.Leg;
import yeohangout.javabeans.LegFlightAirport;

public class FlightSearchUtils {
	
	public static ArrayList<LegFlightAirport> searchFlightByAirport(Connection conn, String depAirport, String arrAirport, Date depDate) throws SQLException{
			ArrayList<LegFlightAirport> seaarchResult = new ArrayList<LegFlightAirport>();
			
			//String sql = "SELECT l.AirlineID, l.FlightNo, l.LegNo, l.DepAirportID, l.ArrAirportID, l.ArrTime, l.DepTime "+
//			String sql = "Select * From howoo.leg l, howoo.airport a1, howoo.airport a2, howoo.flight f "
//					+ "Where l.depAirportID = a1.ID AND l.arrAirportID = a2.ID "
//					+ "AND f.airlineID = l.airlineID AND f.flightNO = l.flightNO " 
//					+ "AND depTime>=? AND l.depAirportID = ? AND l.arrAirportID = ?";		
			String sql = "Select l.airlineID, l.flightNO, l.legNO, l2.legNO, l.depAirportID, l2.arrAirportID, l.depTime, l2.arrTime"
						+ " FROM howoo.leg l, howoo.leg l2 "+
						"WHERE l.airlineID = l2.airlineID AND l.flightNO = l2.flightNO "+
						"AND l.depTime>=? AND l.depAirportID = ? AND l2.arrAirportID = ? ";
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
		
			ps.setDate(1, new java.sql.Date(depDate.getTime()));
			ps.setString(2, depAirport);
			ps.setString(3, arrAirport);
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				
				Leg newLeg = new Leg();
				newLeg.setAirlineID(rs.getString("l.airlineID"));
				newLeg.setFlightNo(rs.getInt("l.flightNo"));
				newLeg.setLegNo(rs.getInt("l.legNo"));
				newLeg.setSecondLegNO(rs.getInt("l2.legNo"));
				newLeg.setDepAirportID(rs.getString("l.depAirportID"));
				newLeg.setArrAirportID(rs.getString("l2.arrAirportID"));
				newLeg.setDepDate(new java.util.Date(rs.getDate("l.depTime").getTime()));
				newLeg.setArrDate(new java.util.Date(rs.getDate("l2.arrTime").getTime()));
				
//				Airport departureAirport = new Airport();
//				departureAirport.setID(rs.getString("a1.ID"));
//				departureAirport.setName(rs.getString("a1.name"));
//				departureAirport.setCity(rs.getString("a1.City"));
//				departureAirport.setCountry(rs.getString("a1.Country"));
				
//				Airport arrivalAirport = new Airport();
//				arrivalAirport.setID(rs.getString("a2.ID"));
//				arrivalAirport.setName(rs.getString("a2.name"));
//				arrivalAirport.setCity(rs.getString("a2.City"));
//				arrivalAirport.setCountry(rs.getString("a2.Country"));
//				
//				Flight newFlight = new Flight(rs.getString("f.airlineID"), rs.getInt("f.FlightNO"), rs.getInt("f.noOfSeats"), rs.getString("f.DaysOperating"),
//						rs.getInt("f.minLengthOfStay"), rs.getInt("f.maxLengthOfStay"));
//				
//				
				//seaarchResult.add(new LegFlightAirport(newLeg, departureAirport, arrivalAirport, newFlight));
				
				//Get how many transfer
				LegFlightAirport resultLFA = new LegFlightAirport(newLeg);
				if(resultLFA.getLeg().getLegNo() == resultLFA.getLeg().getSecondLegNO()) {
					resultLFA.setTransfer(0);
				}else if(resultLFA.getLeg().getLegNo() < resultLFA.getLeg().getSecondLegNO()) {
					resultLFA.setTransfer(resultLFA.getLeg().getSecondLegNO()-resultLFA.getLeg().getLegNo());
				}else {
					
					String sql2 = "SELECT COUNT(*) AS count FROM LEG WHERE airlineID = ? AND flightNO = ?";
					int maxLegs=-1;
					PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(sql2);
					ps2.setString(1, newLeg.getAirlineID());
					ps2.setInt(2, newLeg.getFlightNo());
					
					ResultSet rs2 =  ps2.executeQuery();
					
					if(rs2.next()) {
						maxLegs= rs2.getInt("count");
						System.out.println("maxLegs : "+maxLegs);
					}
					
					if(maxLegs>=resultLFA.getLeg().getSecondLegNO()) {
						resultLFA.setTransfer(maxLegs-resultLFA.getLeg().getSecondLegNO()+resultLFA.getLeg().getLegNo());
					}
					
					rs2.close();
					ps2.close();
				}
				seaarchResult.add(resultLFA);
			}
			
			
			ps.close();
			
			System.out.println("size : "+seaarchResult.size());
			
			return seaarchResult;
	    }
	
	
}

package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Airline;
import yeohangout.javabeans.Person;
import yeohangout.javabeans.Reservation;

public class ReservationUtils {
	
	public static void insertReservation(Connection conn, Reservation resr) throws SQLException {
 		String sql = "Insert into howoo.reservation(ResrDate, BookingFee, totalFare, repSSN, accountNo)"
 				+ "values (?,?,?,?,?)";
 		
 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
 	   
 		pstm.setDate(1, new java.sql.Date(resr.getResrDate().getTime()));
 		pstm.setDouble(2, resr.getBookingFee());
 		pstm.setDouble(3, resr.getTotalFare());
 		pstm.setInt(4,  resr.getRepSSN());
 		pstm.setInt(5, resr.getAccountNo());
 		
 		pstm.executeUpdate();
 		
 		 ResultSet resrNo = pstm.getGeneratedKeys();
 		 
 	       if(resrNo.next()) {		//To avoid error of 'Before start of result set'
 	    	   	  resr.setResrNo(resrNo.getInt(1));
 	       }
	 }
	
	 public static ArrayList<Reservation> searchReservationListByAccountNo(Connection conn, int accountNo) throws SQLException{
	 		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	 		
	 		String sql = "Select * FROM howoo.reservation r Where r.accountNo = ?";
	 		System.out.println("Connection : "+conn);
	 		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
	 		
	 		pstm.setInt(1, accountNo);
	 		
	 		ResultSet rs = pstm.executeQuery();
	
	 		while(rs.next()) {
	 			Reservation searchedReservation = new Reservation();
	 			
	 			searchedReservation.setResrNo(rs.getInt("ResrNo"));
	 			searchedReservation.setResrDate(new java.util.Date(rs.getDate("ResrDate").getTime()));
	 			searchedReservation.setBookingFee(rs.getDouble("bookingFee"));
	 			searchedReservation.setTotalFare(rs.getDouble("totalFare"));
	 			searchedReservation.setRepSSN(rs.getInt("repSSN"));
	 			searchedReservation.setAccountNo(rs.getInt("accountNo"));
	 			
	 			reservations.add(searchedReservation);
	 		
	 		}
	 		
	 		return reservations;
	 }
}

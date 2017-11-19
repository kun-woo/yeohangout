package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Person;
import yeohangout.javabeans.UserAccount;
public class DBUtils {
	
    	
    public static void insertPerson(Connection conn, Person person) throws SQLException {
       String sql = "Insert into howoo.Person (Id,FirstName,LastName, Address, City, State, ZipCode, Telephone, Email) "
       		+ "values (?,?,?,?,?,?,?,?,?)";
       PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
       
       pstm.setInt(1, person.getId());
       pstm.setString(2, person.getFirstName());
       pstm.setString(3, person.getLastName());
       pstm.setString(4, person.getAddress());
       pstm.setString(5, person.getCity());
       pstm.setString(6, person.getState());
       pstm.setInt(7, person.getZipcode());
       pstm.setString(8, null);
       pstm.setString(9, null);
      
       
       pstm.executeUpdate();
    }
    
    public static void insertUser(Connection conn, UserAccount user) throws SQLException {
    		String sql = "Insert into howoo.customer(Id, AccountNo, CreditCardNo, CreationDate, Rating) " 
    				+ "values (?,?,?,?,?)";
    		
    		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
    	   
    		pstm.setInt(1,user.getUserID());
    		pstm.setInt(2, user.getAccountNo());
    		pstm.setInt(3, user.getCreditCardNo());
    		pstm.setDate(4, user.getAccountCreationDate());
    		pstm.setInt(5, user.getRating());
    		
    		pstm.executeUpdate();
    }
}

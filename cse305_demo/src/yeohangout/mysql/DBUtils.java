package yeohangout.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import yeohangout.javabeans.Person;
import yeohangout.javabeans.UserAccount;
public class DBUtils {
	
    	
    public static void insertPerson(Connection conn, Person person) throws SQLException {
       String sql = "Insert into howoo.Person (FirstName,LastName, Address, City, State, ZipCode, Telephone, Email) "
       		+ "values (?,?,?,?,?,?,?,?)";
       PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       
       System.out.println(person.getFirstName()+" "+person.getLastName() +" "+ person.getAddress()
       	+" "+person.getCity()+ " "+ person.getEmail() + " "+person.getState() + " "+person.getZipcode() + " "+person.getTelephone());
       pstm.setString(1, person.getFirstName());
       pstm.setString(2, person.getLastName());
       pstm.setString(3, person.getAddress());
       pstm.setString(4, person.getCity());
       pstm.setString(5, person.getState());
       pstm.setInt(6, person.getZipcode());
       pstm.setString(7, person.getTelephone());
       pstm.setString(8, person.getEmail());
       
       
       pstm.executeUpdate();
       
       ResultSet personID = pstm.getGeneratedKeys();
       person.setId(personID.getInt(1));
       System.out.println("person ID "+person.getId());

    }
    
    public static void insertUser(Connection conn, UserAccount user) throws SQLException {
    		String sql = "Insert into howoo.customer(Id, CreditCardNo, CreationDate, Rating, UserName, Pwd) " 
    				+ "values (?,?,?,?,?,?)";
    		
    		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	   
    		pstm.setInt(1, user.getPersonID());
    		pstm.setInt(2, user.getCreditCardNo());
    		pstm.setDate(3, user.getAccountCreationDate());
    		pstm.setInt(4, user.getRating());
    		pstm.setString(5, user.getUserID());
    		pstm.setString(6, user.getPassword());
    		
    		pstm.executeUpdate();

    	    ResultSet userAccount = pstm.getGeneratedKeys();
    	    user.setAccountNo(userAccount.getInt(2));
    }
    
    public static UserAccount searchUser(Connection conn, int userId) throws SQLException{
    		
    		String sql = "Select * FROM howoo.customer c Where c.id = ?";
    		
    		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
    		
    		pstm.setInt(1, userId);
    		
    		
    		ResultSet rs = pstm.executeQuery();
    		while(rs.next()) {
    			UserAccount loginedUser = new UserAccount();
    			loginedUser.setPersonID(rs.getInt("Id"));
    			loginedUser.setAccountNo(rs.getInt("AccountNo"));
    			loginedUser.setCreditCardNo(rs.getInt("CreditCardNo"));
    			loginedUser.setRating(rs.getInt("Rating"));
    			loginedUser.setAccountCreationDate(rs.getDate("CreationDate"));
    			loginedUser.setUserID(rs.getString("UserName"));
    			loginedUser.setPasswor(rs.getString("Pwd"));
    			return loginedUser;
    		}
    		
    		return null;

    }
}

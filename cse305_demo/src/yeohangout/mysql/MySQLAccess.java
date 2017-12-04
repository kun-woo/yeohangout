package yeohangout.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jude Hokyoon Woo
 *
 * Nov 11, 2017
 * 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 */
public class MySQLAccess {
	private Connection connect;
    private Statement statement;
    private ResultSet resultSet;

	public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://mysql2.cs.stonybrook.edu:3306/howoo?"
                            + "user=howoo&password=111255764");

        } catch (Exception e) {
            throw e;
        } 
    }
	
	public Connection getConnection() {
		return connect;
	}
	
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}

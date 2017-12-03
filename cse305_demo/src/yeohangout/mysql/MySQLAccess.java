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
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

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
        } finally {
            //close();
        }

    }
	
	public Connection getConnection() {
		return connect;
	}
	

    private void writeMetaData (ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String Name = resultSet.getString("Name");
            System.out.println("id: " + id);
            System.out.println("Name: " + Name);
        }
    }

    // You need to close the resultSet
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

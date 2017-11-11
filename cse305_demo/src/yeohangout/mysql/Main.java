package yeohangout.mysql;

/**
 * @author Jude Hokyoon Woo
 * 
 * Nov 11, 2017
 */
public class Main {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
	}

}

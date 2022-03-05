package salesForce_DB_Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerUserName {
	/*
	 * this is a dummy class to explain how data base work.
	 */
	public String getUserNameFromDataBase() throws SQLException {

	
		
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // sql server driver code

				String url = "jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;" + "databaseName=FaruqAcademy;";
				String user = "Faruq";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				String userName = "SELECT user_name FROM account where first_name='Faruq'";		
				
				ResultSet rs = stmt.executeQuery(userName);
				
				
				  while (rs.next()) { 
					  String uName=rs.getString("user_name");
				  System.out.println(uName);
				  break; }
				 
				
			con.close();			
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return toString()  ;
			}
public static void main(String[] args) throws SQLException {
	DbManagerUserName dm = new DbManagerUserName();
	dm.getUserNameFromDataBase();
}
	

	}



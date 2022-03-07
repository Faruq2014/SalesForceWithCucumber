package salesForce_DB_Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerPassword {
	/*
	 * this is a dummy class to explain how data base work.
	 */
	public String getPasswordFromDataBase() throws SQLException {

            String pword = null;
		
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // sql server driver code

				String url = "jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;" + "databaseName=FaruqAcademy;";
				String user = "Faruq";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				String pass = "SELECT password FROM account where first_name='Faruq'";
				ResultSet rs = stmt.executeQuery(pass);
				//String pword;
				while (rs.next()) {
					 pword=rs.getString("password");
					System.out.println(pword);					
			}
			
			con.close();			
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return pword ; 
			}
public static void main(String[] args) throws SQLException {
	DbManagerPassword dm = new DbManagerPassword();
	dm.getPasswordFromDataBase();
}
	

	}

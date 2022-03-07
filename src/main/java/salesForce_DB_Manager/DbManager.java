package salesForce_DB_Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	String url = "jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;" + "databaseName=FaruqAcademy;";
	String user = "Faruq";
	String password = "1234";
	Connection con;
	Statement stmt;
	ResultSet rs;



	public String getUserNameFromDataBase() throws SQLException {

		String uName=null;

		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		// sql server driver code, you can open it or block this.
		try {
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String userName = "SELECT user_name FROM account where first_name='Faruq'";		
			rs = stmt.executeQuery(userName);
			while (rs.next()) { 
				uName=rs.getString("user_name");
				System.out.println(uName);
			}

		} catch (Exception e) { e.printStackTrace(); }
		
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		return uName   ;
	}

	
	public String getPasswordFromDataBase()  {

		String pword = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String pass = "SELECT password FROM account where first_name='Faruq'";
			rs = stmt.executeQuery(pass);
			while (rs.next()) {
				pword=rs.getString("password");
				System.out.println(pword);	
				
			}

		} catch (SQLException e) {e.printStackTrace();}
		
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		
	
		return pword ; 
	}
	
	
	public static void main(String[] args) throws SQLException {
		DbManager db= new DbManager();
		db.getUserNameFromDataBase();
		db.getPasswordFromDataBase();
	}
}

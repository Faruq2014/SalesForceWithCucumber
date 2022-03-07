package salesForce_Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesForce_DB_Manager.DbManager;
import salesForce_DB_Manager.DbManagerPassword;
import salesForce_DB_Manager.DbManagerUserName;
import salesForce_Managers.BrowserManager;
import salesForce_Managers.PageObjectManager;
import salesForce_Pages.LoginPage;

public class LoginTestWithDb {
	WebDriver driver;
	PageObjectManager pageObjectManager;
	BrowserManager browserManager;
	LoginPage loginPage;
	
	@Given("user open SalesForce Application from local")
	public void user_open_sales_force_application_from_local() {
		   System.out.println("Bismillah");
		   browserManager= new BrowserManager();
		  driver= browserManager.getDriver();
		}

	@When("user enter userName and Password from DataBase")
	public void user_enter_user_name_and_password_from_data_base() throws SQLException {
		  System.out.println("Bismillah");
			pageObjectManager = new PageObjectManager(driver);
			LoginPage loginPage=pageObjectManager.getLoginPage();
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // sql server driver code
				String url = "jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;" + "databaseName=FaruqAcademy;";
				String user = "Faruq";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();	
				String pass = "SELECT user_name,password FROM account where first_name='Faruq'";
				ResultSet rs = stmt.executeQuery(pass);
				while (rs.next()) {
					String uName=rs.getString("user_name");
					String pword=rs.getString("password");
					System.out.println(uName);
					System.out.println(pword);
					loginPage.getUserName(uName);
					loginPage.getPassword(pword);
			}
			
			con.close();			
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
				
	    loginPage.getLogin();		
			
	}

	@Then("user validate DataBase for Data Validity")
	public void user_validate_data_base_for_data_validity() {
		  System.out.println("Bismillah");
		//browserManager.closeDriver();
			driver.close();
	}

}

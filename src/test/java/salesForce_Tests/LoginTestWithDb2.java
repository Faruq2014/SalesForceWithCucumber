			package salesForce_Tests;
			
			import java.sql.SQLException;
			
			import org.openqa.selenium.WebDriver;
			
			import io.cucumber.java.en.Given;
			import io.cucumber.java.en.Then;
			import io.cucumber.java.en.When;
			import salesForce_DB_Manager.DbManager;
			import salesForce_Managers.BrowserManager;
			import salesForce_Managers.PageObjectManager;
			import salesForce_Pages.LoginPage;
			
			public class LoginTestWithDb2 {
				WebDriver driver;
				PageObjectManager pageObjectManager;
				BrowserManager browserManager;
				LoginPage loginPage;
				DbManager db; 
				@Given("user open SalesForce Application from chrome")
				public void user_open_sales_force_application_from_chrome() {
			
					System.out.println("Bismillah");
					browserManager= new BrowserManager();
					driver= browserManager.getDriver();	   
				}
			
				@When("user enter {string} and {string} from DataBase2")
				public void user_enter_and_from_data_base2(String uName, String pword) {
					pageObjectManager = new PageObjectManager(driver);
					loginPage=pageObjectManager.getLoginPage();
					db= new DbManager();
					try {
						loginPage.getUserName(db.getUserNameFromDataBase());
						loginPage.getPassword(db.getPasswordFromDataBase());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					loginPage.getLogin();
				}
			
				@Then("user validate DataBase2 for Data Validity")
				public void user_validate_data_base2_for_data_validity() {
					driver.close(); 
				}
			}

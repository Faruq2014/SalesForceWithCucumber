package salesForce_Tests;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesForce_Managers.BrowserManager;
import salesForce_Managers.PageObjectManager;
import salesForce_Pages.LoginPage;


public class LoginTest {
	WebDriver driver;
	PageObjectManager pageObjectManager;
	BrowserManager browserManager;
	LoginPage loginPage;
	
	@Given("user open SalesForce Appl")
	public void userOpenSalesForceAppl() {
	   System.out.println("Bismillah");
	   browserManager= new BrowserManager();
	  driver= browserManager.getDriver();
	}
	@When("user enter userName and Password")
	public void userEnterUserNameAndPassword() {
		  System.out.println("Bismillah");
			pageObjectManager = new PageObjectManager(driver);
			LoginPage loginPage=pageObjectManager.getLoginPage();
			loginPage.getUserName("test");
			loginPage.getPassword("test123");
			loginPage.getLogin();
			
			
	}
	@Then("user validate error message")
	public void userValidateErrorMessage() {
		  System.out.println("Bismillah");
		//browserManager.closeDriver();
			driver.close();
	}



	
}

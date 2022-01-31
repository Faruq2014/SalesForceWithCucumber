package salesForce_Tests;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesForce_Managers.BrowserManager;
import salesForce_Managers.PageObjectManager;
import salesForce_Pages.RegistrationPage;


public class RegistrationTest {
	WebDriver driver;
	PageObjectManager pageObjectManager;
	BrowserManager browserManager;
	RegistrationPage regPage;
	
	
	@Given("User open application for salesForce")
	public void userOpenApplicationForSalesForce() {
		browserManager = new BrowserManager();
		driver=browserManager.getDriver();
	}
	@When("user complete registration page")
	public void userCompleteRegistrationPage() {
		pageObjectManager=new PageObjectManager(driver);
		RegistrationPage regPage=pageObjectManager.getRegistrationPage();
		regPage.tryItFree();
		regPage.firstName("Kamal");
		regPage.lastName("Khan");
		
	}
	@Then("I validate the outcomes")
	public void iValidateTheOutcomes() {
		//browserManager.closeDriver();
		driver.close();
	}



}

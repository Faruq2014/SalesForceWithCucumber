package salesForce_Tests;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesForce_Managers.BrowserManager;
import salesForce_Managers.PageObjectManager;
import salesForce_Pages.RegistrationPage;
import salesForce_XmlManager.ReadFromXML;


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
		regPage=pageObjectManager.getRegistrationPage();
		regPage.tryItFree();
		ReadFromXML xml= new ReadFromXML();
		regPage.firstName(xml.getfirstName());
		regPage.lastName(xml.getlastName());
		regPage.jobTitle(xml.getjobTitle());
		regPage.emailAddress(xml.getemail());
		regPage.phoneNumber(xml.getphone());
		//regPage.employees();
		regPage.getCompEmpl();
		regPage.getEmpOpt();
		regPage.compName(xml.getCompany());
		regPage.compCountryName();
		regPage.compCountry();
		regPage.freeTrial();
		
	}
	@Then("I validate the outcomes")
	public void iValidateTheOutcomes() {
		driver.close();
	}



}

package salesForce_Tests;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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

	Scenario scn;
	@Before
	public void beforeScenario(Scenario scenario) {
		this.scn = scenario;
		//browserManager = new BrowserManager();
		//driver=browserManager.getDriver();
	}
	

	
	
	
	@Given("User open application for salesForce")
	public void userOpenApplicationForSalesForce() {
		browserManager = new BrowserManager();
		driver=browserManager.getDriver();
		scn.log("Browser open");
		String actualTitle =driver.getTitle();
		String expectedTitle="Login | Salesforce";
		Assert.assertEquals("Title did not match", actualTitle, expectedTitle);
		scn.log("Salesforce title verified.");
		 scn.log("Verified application open");
		 
	}
	@When("user complete registration page")
	public void userCompleteRegistrationPage() {
		scn.log("serCompleteRegistrationPage Test Started");
		pageObjectManager=new PageObjectManager(driver);
		regPage=pageObjectManager.getRegistrationPage();
		regPage.tryItFree();
		ReadFromXML xml= new ReadFromXML();
		regPage.firstName(xml.getfirstName());
		scn.log("first name done");
		regPage.lastName(xml.getlastName());
		scn.log("last name done");
		regPage.jobTitle(xml.getjobTitle());
		scn.log("job title  done");
		regPage.emailAddress(xml.getemail());
		regPage.phoneNumber(xml.getphone());
		//regPage.employees();
		regPage.getCompEmpl();
		regPage.getEmpOpt();
		regPage.compName(xml.getCompany());
		regPage.compCountryName();
		regPage.compCountry();
		regPage.freeTrial();
		scn.log("serCompleteRegistrationPage Test Finished");
	}
	@Then("I validate the outcomes")
	public void iValidateTheOutcomes() {
		scn.log("Registration page validation started..");
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus";
		Assert.assertEquals("Title did not match", actualUrl, expectedUrl);
		 scn.log("Registration page validated..");
	}
	
	/*
	@After
	public void afterStep() {		
		scn.log(scn.getName()+" >>scenario completed");
		System.out.println("-----------------End of Scenario-----------------");		
		if (scn.isFailed()) {						
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", scn.getName());
		}
		driver.quit();
		scn.log("Browser close");
	}
	*/
	@After
	public void tearDown() {
		String name1=scn.getName();
		TakesScreenshot camera1 = (TakesScreenshot) driver;
		byte[] pic1=camera1.getScreenshotAs(OutputType.BYTES);
		scn.attach(pic1, "image/png", name1);
		
		if(scn.isFailed()) {
			String name=scn.getName();
		scn.log(name +" is fail");
		TakesScreenshot camera = (TakesScreenshot) driver;
		byte[] pic=camera.getScreenshotAs(OutputType.BYTES);
		scn.attach(pic, "image/png", name);
		}
		driver.quit();
		scn.log("application testing compelete");
	}

}

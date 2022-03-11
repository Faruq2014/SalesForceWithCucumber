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
import salesForce_Pages.LoginPage;


public class LoginTest {
	WebDriver driver;
	PageObjectManager pageObjectManager;
	BrowserManager browserManager;
	LoginPage loginPage;
	
	Scenario scn;
	@Before
	 public void beforeScenario(Scenario scenario) {
		this.scn = scenario;
	}
	
	@Given("user open SalesForce Appl")
	public void userOpenSalesForceAppl() {
	   System.out.println("Bismillah");
	    browserManager= new BrowserManager();
		driver= browserManager.getDriver();
	   String actualTitle =driver.getTitle();
		String expectedTitle="Login | Salesforce";
		Assert.assertEquals("Title did not match", actualTitle, expectedTitle);
		 scn.log("Verified application open");
	 
	   
	}
	@When("user enter userName and Password")
	public void userEnterUserNameAndPassword() {
		  System.out.println("Bismillah");
			pageObjectManager = new PageObjectManager(driver);
			LoginPage loginPage=pageObjectManager.getLoginPage();
			String projectPath = System.getProperty("user.dir");
			String fileName="/src/main/resources/config/data.xlsx";
			String fullPath=projectPath+fileName;
			salesForce_ExcellManager.ExcelUtilsWithReturn excel = new salesForce_ExcellManager.ExcelUtilsWithReturn(fullPath,"Sheet0");
			loginPage.getUserName(excel.getStringCellData(1, 0));
			loginPage.getPassword(excel.getStringCellData(1, 1));
			//loginPage.getLogin();		
			scn.log("done login test");
	}
	@Then("user validate error message")
	public void userValidateErrorMessage() {
		  System.out.println("Bismillah");
		  String actualUrl=driver.getCurrentUrl();
			String expectedUrl="https://login.salesforce.com";
			Assert.assertNotEquals("Url did not match", actualUrl, expectedUrl);
			 scn.log("Registration page validated..");
	}
	
	@After
	private void afterStep() {		
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
	
}

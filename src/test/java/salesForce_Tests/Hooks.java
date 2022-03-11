package salesForce_Tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import salesForce_Managers.BrowserManager;
import salesForce_Managers.PageObjectManager;

public class Hooks {
	//WebDriver driver;
	//PageObjectManager pageObjectManager;
	//BrowserManager browserManager;
	Scenario scn;
	@Before
	public void beforeScenario(Scenario scenario) {
		this.scn = scenario;
		scn.log(scn.getName()+" >>scenario started");
		System.out.println("-----------------Start of Scenario-----------------");
		System.out.println("Scenario name is ----"+scenario.getName());
	
}
/*
	@After
	public void afterStep() {
		browserManager = new BrowserManager();
		driver=browserManager.getDriver();
		
		scn.log(scn.getName()+" >>scenario completed");
		System.out.println("-----------------End of Scenario-----------------");
		
		if (scn.isFailed()) {			
			
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", scn.getName());
		}
		
		if (scn.getStatus().SKIPPED != null) {
			driver=browserManager.getDriver();
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			//scn.attach(data, "image/png");
			scn.attach(data, "image/png", scn.getName());
		}
		
		//driver.quit();
	
	}
*/
}

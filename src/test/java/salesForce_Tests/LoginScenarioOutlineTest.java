package salesForce_Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginScenarioOutlineTest {
	
	@Given("validator open application")
	public void validatorOpenApplication() {
		
	}
	@When("validator enter {string} and enter {string} in the app")
	public void validatorEnterAndEnterInTheApp(String userName, String password) {
	    
	}
	@Then("validator click login button")
	public void validatorClickLoginButton() {
		
	}
	@Then("validate successfully login message")
	public void validateSuccessfullyLoginMessage() {
		System.out.println("done");
	}



}

package salesForce_Tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("-----------------Start of Scenario-----------------");
		System.out.println("Scenario name is ----"+scenario.getName());
	}
	
	@After
	public void afterStep() {
		System.out.println("-----------------End of Scenario-----------------");
	}
}

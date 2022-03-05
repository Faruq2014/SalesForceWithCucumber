package salesForce_StepRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty",
				"html:target/CucumberReport.html",
				"json:target/cucumber-report.json",
				"junit:target/cucumber-report.xml"
				},
		snippets=SnippetType.CAMELCASE,		
		features="src/test/resources/Features",

				tags="@db",
		glue= {"salesForce_Tests"},
		monochrome = true,
		dryRun=false
		)
public class SalesForceCucumberRunner {

}

package salesForce_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how=How.ID,using="signup_link") private WebElement signupLink;
	public WebElement tryItFree() {
		signupLink.click();
		return signupLink;
	}

	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'UserFirstName')]") private WebElement userFirstN;
	public WebElement firstName(String firstName) {
		userFirstN.sendKeys(firstName);
		return userFirstN;
	}

	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'UserLastName')]") private WebElement userlastN;
	public WebElement lastName(String lastName) {
		userlastN.sendKeys(lastName);
		return userlastN;
	}
}

package salesForce_Managers;

import org.openqa.selenium.WebDriver;

import salesForce_Pages.LoginPage;
import salesForce_Pages.RegistrationPage;

public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private RegistrationPage regPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public  LoginPage getLoginPage() {
		return (loginPage==null)? loginPage = new LoginPage(driver):loginPage;

	}

	public RegistrationPage getRegistrationPage() {
		return (regPage==null)? regPage=new RegistrationPage(driver):regPage;

	}

}

package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTech.HomePageUI;
import pageUIs.liveTech.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public	LoginPageObject (WebDriver driver) {
		this.driver =driver;
		
	}

	public RegisterPageObject clickToCreateAnAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGenerator.getRegisterPage(driver);
		
	}

	
	

}

package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTech.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public	HomePageObject (WebDriver driver) {
		this.driver =driver;
		
	}

	public LoginPageObject openMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGenerator.getLoginPage(driver);
	}
	

}

package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTech.AccountDashBoardPageUI;
import pageUIs.liveTech.HomePageUI;

public class AccountDashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public	AccountDashboardPageObject (WebDriver driver) {
		this.driver =driver;
		
	}
	
	public String getSuccessMessageText() {
		waitForAllElementVisible(driver, AccountDashBoardPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, AccountDashBoardPageUI.SUCCESS_MESSAGE);
	}

	
	

}

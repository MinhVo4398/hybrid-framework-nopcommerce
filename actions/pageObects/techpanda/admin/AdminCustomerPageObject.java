package pageObects.techpanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTech.admin.AdminCustomnerPageUI;
import pageUIs.liveTech.admin.AdminLoginPageUI;

public class AdminCustomerPageObject extends BasePage {
	WebDriver driver;
	
	public AdminCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopUp() {
		clickToElement(driver, AdminCustomnerPageUI.ClOSE_POP_UP);
		
		
		
	}

	public void enterToHeaderTextBoxByLabel(String headerTextBox, String value) {
		waitForElementVisible(driver, AdminCustomnerPageUI.TEXTBOX_BY_HEADER, headerTextBox);
		sendkeyToElement(driver, AdminCustomnerPageUI.TEXTBOX_BY_HEADER, value, headerTextBox);
		
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomnerPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomnerPageUI.SEARCH_BUTTON);
		
	}
	
//	public boolean checkNameAndEmailDisplay() {
//		
//	}
}

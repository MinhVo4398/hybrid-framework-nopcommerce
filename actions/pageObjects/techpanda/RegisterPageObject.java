package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTech.HomePageUI;
import pageUIs.liveTech.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public	RegisterPageObject (WebDriver driver) {
		this.driver =driver;
		
	}

	

	public void inputToFirstNameTextBox(String firstName) {
		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
		
	}

	

	public void inputToLastNameTextBox(String lastName) {
		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
		
	}

	public void inputToEmailTextBox(String emailAddress) {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, emailAddress);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
		
	}
	public AccountDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGenerator.getAccountDashBoardPage(driver);
	}



}

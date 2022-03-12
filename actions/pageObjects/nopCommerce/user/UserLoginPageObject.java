package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    //2 return   new HomePageObject(driver);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public String getErrorMessageAtEmailTextBox() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
        return  getElementText(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);

    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
        return  getElementText(driver,LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
    }


	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}

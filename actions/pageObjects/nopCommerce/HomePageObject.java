package pageObjects.nopCommerce;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    // Biến global;
    private WebDriver driver;

    //constructor
    public  HomePageObject(WebDriver driver) {
      //  Biến local
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        //2
    // return new RegisterPageObject(driver);
        
        //3
        return PageGeneratorManager.getRegisterPage(driver);

    }

    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
  //2    return  new LoginPageObject(driver);
        return PageGeneratorManager.getLoginPage(driver);
       
    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

	public CustomerInforPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);		
		 clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
		 
	}
}

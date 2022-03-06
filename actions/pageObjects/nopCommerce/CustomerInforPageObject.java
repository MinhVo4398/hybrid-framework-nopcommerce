package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {
	 // Biến global;
    private WebDriver driver;

    //constructor
    public  CustomerInforPageObject(WebDriver driver) {
      //  Biến local
        this.driver = driver;
    }

	

	public boolean isCustomerInforPageDisplayed() {
			
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
	return	isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
		
		
	}






	
}

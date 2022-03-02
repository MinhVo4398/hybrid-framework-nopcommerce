package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountPageObject extends BasePage {
	 // Biến global;
    private WebDriver driver;

    //constructor
    public  MyAccountPageObject(WebDriver driver) {
      //  Biến local
        this.driver = driver;
    }

	public void clickToNewsletterCheckbox() {
		// TODO Auto-generated method stub
		
	}

	
}

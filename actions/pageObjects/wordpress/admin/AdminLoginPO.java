package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminLoginPO  extends BasePage{
	WebDriver driver;
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

}

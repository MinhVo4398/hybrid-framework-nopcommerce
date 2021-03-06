package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.RegisterPageObject;


public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
	

}

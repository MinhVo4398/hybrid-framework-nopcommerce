package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static AccountDashboardPageObject getAccountDashBoardPage(WebDriver driver) {
		return new AccountDashboardPageObject(driver);
	}
}

package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import exception.BrowserNotSupport;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) throws BrowserNotSupport {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		System.out.println("Run on " + browserName);
		if (browserList == BrowserList.FIREFOX) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();

			// Browser Option : Selenium 3.xx
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == BrowserList.H_CHROME) {
			System.out.println(browserName);
			WebDriverManager.chromedriver().setup();

			// Browser Option : Selenium 3.xx
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if (browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browserList == BrowserList.OPERA) {
			// opera c??? t???i c??i m???i nh???t
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}

		else if (browserList == BrowserList.COCOC) {
			// C???c C???c browser tr??? ??i 5-6 version ra ChromeDriver
			WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();

			ChromeOptions options = new ChromeOptions();
			if (GlobalConstant.OS_NAME.startsWith("Window")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary("...");
			}

			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.BRAVE) {
			// Brave browser version n??o d??ng chromedriver version ????

			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);

		}

		else {
			throw new BrowserNotSupport(browserName);
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstant.LONG_TIMEOUT, TimeUnit.SECONDS);
		// M??? Url n?? qua trang HomePage
		driver.get(GlobalConstant.PORTAL_TESTING_URL);

		return driver; // return driver ????? map qua b??n Class k??? th???a x??i

	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		}
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);

		}

		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("opera")) {
			// opera c??? t???i c??i m???i nh???t
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equals("cococ")) {
			// C???c C???c browser tr??? ??i 5-6 version ra ChromeDriver
			WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();

			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("brave")) {
			// Brave browser version n??o d??ng chromedriver version ????

			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);

		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstant.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;

	}

	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com/";

		} else if (environment == EnvironmentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} else if (environment == EnvironmentList.STAGING) {
			envUrl = "https://staging.orangehrm.live.com";
		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "https://production.orangehrm.live.com";
		}

		return envUrl;
	}

	protected int generateFakeNumber() {

		Random rd = new Random();
		return rd.nextInt(9999);

	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {																	
			Assert.assertTrue(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			// Add l???i v??o ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			
			Assert.assertFalse(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}


	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	
	
	}


package commons;

import factoryEnvironment.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	
	//constructor
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	

	// Hàm này giữ lại cho những bài trước xài
	protected WebDriver getBrowserDriverLocal (String browserName) throws BrowserNotSupport {

		browser browserList = browser.valueOf(browserName.toUpperCase());

		if (browserList == browser.FIREFOX) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);

		} else if (browserList == browser.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new FirefoxDriver(options);

		} else if (browserList == browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

		} else if (browserList == browser.H_CHROME) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserList == browser.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if (browserList == browser.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browserList == browser.OPERA) {
			// opera cứ tải cái mới nhất
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}

		else if (browserList == browser.COCOC) {
			// Cốc Cốc browser trừ đi 5-6 version ra ChromeDriver
			WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();

			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Window")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary("...");
			}

			driver = new ChromeDriver(options);

		} else if (browserList == browser.BRAVE) {
			// Brave browser version nào dùng chromedriver version đó

			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);

		}

		else {
			throw new BrowserNotSupport(browserName);
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		// Mở Url nó qua trang HomePage
		driver.get(GlobalConstants.PORTAL_TESTING_URL);
		driver.manage().window().maximize();

		return driver; // return driver để map qua bên Class kế thừa xài

	}
	protected WebDriver getBrowserDriver(String browserName, String appUrl, String envName, String ipAddress, String portNumber, String osName, String osVersion) {
		switch( envName) {
			case "local":
				driver = new LocalFactory(browserName).createDriver();
			break;

			case "grid":
				driver = new GridFactory(browserName,ipAddress,portNumber).createDriver();
				break;

			case "browserStack":
			driver = new BrowserStackFactory(browserName, osName, osVersion).createDriver();
				break;
			case "saucelab":
				driver = new LocalFactory(browserName).createDriver();
				break;
			case "crossBrowser":
				driver = new LocalFactory(browserName).createDriver();
				break;
			case "lambda":
				driver = new LocalFactory(browserName).createDriver();
				break;



			default:
				driver = new LocalFactory(browserName).createDriver();
				break;
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}





	// Hàm này cho SauceLab
	protected WebDriver getBrowserDriverSauceLab(String browserName, String appUrl, String osName) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", "latest");
		capability.setCapability("name", "Run on " + osName + " | " + browserName );

		Map<String, Object> sauceOptions = new HashMap<>();
		if(osName.contains("Windows")) {
			sauceOptions.put("screenResolution", "1920x1080");
		}
		else {
			sauceOptions.put("screenResolution", "1920x1440");
		}
		capability.setCapability("sauce:options", sauceOptions);


		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELAB_URL),capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);

		return driver; // return driver để map qua bên Class kế thừa xài

	}

	// Hàm này dùng cho CrossBrowserTesting
	protected WebDriver getBrowserDriverCrossBrowser(String browserName, String appUrl, String osName) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browserName);
		capability.setCapability("platform", osName);
		if(osName.contains("Windows")) {
			capability.setCapability("screenResolution", "1920x1080");
		}
		else {
			capability.setCapability("screenResolution", "2560x1600");

		}

		capability.setCapability("name", "Run on " + osName + " | " + browserName );

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.CORSS_URRL),capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);

		return driver; // return driver để map qua bên Class kế thừa xài

	}

	// Hàm này dùng cho Lambda
	protected WebDriver getBrowserDriverLambda(String browserName, String appUrl, String osName) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browserName);
		capability.setCapability("platform", osName);
		capability.setCapability("version", "latest");
		capability.setCapability("visual", true);
		capability.setCapability("video", true);

		if(osName.contains("Windows")) {
			capability.setCapability("screenResolution", "1920x1080");
		}
		else {
			capability.setCapability("screenResolution", "2048x1536");
		}

		capability.setCapability("name", "Run on " + osName + " | " + browserName );

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL),capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);

		return driver; // return driver để map qua bên Class kế thừa xài

	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected String getEnvironmentUrl(String environmentName) {
		String envUrl = null;
		environment environment = factoryEnvironment.environment.valueOf(environmentName.toUpperCase());
		switch (environment) {
			case DEV:
				envUrl = "https://demo.nopcommerce.com/";
				break;
			case TESTING:
				envUrl = "https://testing.nopcommerce.com";
				break;
			case STAGING:
				envUrl = "https://staging.nopcommerce.com";
				break;
			case PRE_PRODUCTION:
				envUrl = "https://pre-prod.nopcommerce.com";
				break;

			case PROD:
				envUrl = "https://prod.nopcommerce.com";
				break;

			default:
				envUrl = null;
				break;
		}

		return envUrl;
	}

	protected int generateFakeNumber() {

		Random rd = new Random();
		return rd.nextInt(99999);

	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {																	
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}


	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllureReport() {
		try {
		
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	
	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
	
	}


	


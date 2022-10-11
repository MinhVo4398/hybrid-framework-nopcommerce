package factoryEnvironment;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LocalFactory {
    WebDriver driver;
    private String browserName;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }
    public WebDriver createDriver( ) {
        browser browser = factoryEnvironment.browser.valueOf(browserName.toUpperCase());

        if (browser == factoryEnvironment.browser.FIREFOX) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);

        } else if (browser == factoryEnvironment.browser.H_FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size = 1920x1080");
            driver = new FirefoxDriver(options);

        } else if (browser == factoryEnvironment.browser.CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);

        } else if (browser == factoryEnvironment.browser.H_CHROME) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size = 1920x1080");
            driver = new ChromeDriver(options);
        } else if (browser == factoryEnvironment.browser.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else if (browser == factoryEnvironment.browser.IE) {
            WebDriverManager.iedriver().arch32().setup();
            driver = new InternetExplorerDriver();
        }

        else if (browser == factoryEnvironment.browser.OPERA) {
            // opera cứ tải cái mới nhất
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        else if (browser == factoryEnvironment.browser.COCOC) {
            // Cốc Cốc browser trừ đi 5-6 version ra ChromeDriver
            WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();

            ChromeOptions options = new ChromeOptions();
            if (GlobalConstants.OS_NAME.startsWith("Window")) {
                options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
            } else {
                options.setBinary("...");
            }

            driver = new ChromeDriver(options);

        } else if (browser == factoryEnvironment.browser.BRAVE) {
            // Brave browser version nào dùng chromedriver version đó

            WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            driver = new ChromeDriver(options);

        }

        else {
            throw new RuntimeException("Please enter correct browswer name");
        }

        return driver; // return driver để map qua bên Class kế thừa xài
    }
}

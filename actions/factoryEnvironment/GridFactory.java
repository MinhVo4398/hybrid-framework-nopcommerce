package factoryEnvironment;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {
    private WebDriver driver;
    private String browserName ;
    private String ipAddress;
    private String portNumber;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }
    public WebDriver createDriver() {
        browser browserList = browser.valueOf(browserName.toUpperCase());
        DesiredCapabilities capabilitity = null;

        if (browserList == browser.FIREFOX) {

            WebDriverManager.firefoxdriver().setup();
            capabilitity =DesiredCapabilities.firefox();
            capabilitity.setBrowserName("firefox");
            capabilitity.setPlatform(Platform.ANY);

            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilitity);

        }

        else if (browserList == browser.CHROME) {
            WebDriverManager.chromedriver().setup();
            capabilitity =DesiredCapabilities.chrome();
            capabilitity.setBrowserName("chrome");
            capabilitity.setPlatform(Platform.ANY);

            ChromeOptions options = new ChromeOptions();
            options.merge(capabilitity);

        }
        else if (browserList == browser.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
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
            throw new RuntimeException("Please enter correct browser name!");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub",ipAddress,portNumber)),capabilitity);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  driver;
    }
}

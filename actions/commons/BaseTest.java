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

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir"); // lấy ra đường dẫn

    protected WebDriver getBrowserDriver(String browserName) {
        System.out.println("Run on " +browserName);
        if(browserName.equals("firefox")) {
           // System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
       else if(browserName.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();

            // Browser Option : Selenium 3.xx
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size = 1920x1080");
            driver = new FirefoxDriver(options);
        }
        else if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equals("h_chrome")) {
            System.out.println(browserName);
            WebDriverManager.chromedriver().setup();

            // Browser Option : Selenium 3.xx
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size = 1920x1080");
            driver = new ChromeDriver(options);
        }
        else if(browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else if(browserName.equals("ie")) {
            WebDriverManager.iedriver().arch32().setup();
            driver = new InternetExplorerDriver();
        }

        else if(browserName.equals("opera")) {
            //opera cứ tải cái mới nhất
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        else if(browserName.equals("coccoc")) {
            // Cốc Cốc browser trừ đi 5-6 version ra ChromeDriver
            WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();

            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);

        }
        else if(browserName.equals("brave")) {
            //Brave browser version nào dùng chromedriver version đó

            WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            driver = new ChromeDriver(options);

        }

        else {
            throw new RuntimeException("Browser name invalid.");
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Mở Url nó qua trang  HomePage
        driver.get(GlobalConstant.PORTAL_PAGE_URL);
        
      //  driver.get("http://live.techpanda.org/");
        return driver;  // return driver để map qua bên Class kế thừa xài

    }
    
    
	protected int generateFakeNumber() {
		Random rd = new Random();
	return	rd.nextInt(9999);

	}
}

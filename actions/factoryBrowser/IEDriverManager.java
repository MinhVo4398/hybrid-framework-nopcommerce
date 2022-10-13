package factoryBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class IEDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        if (!IS_OS_WINDOWS) {
            throw new BrowserNotSupportedException("IE is not supported on" + System.getProperty("os.name"));

        }
        WebDriverManager.iedriver().architecture(Architecture.X32).setup();
        //Selenium 3x
        InternetExplorerOptions options = new InternetExplorerOptions();

        options.setCapability("ie.usePerProcessProxy", "true");
        options.setCapability("requireWindowFocus", "true");
        options.setCapability("ie.browserCommandLineSwitches", "-private");
        options.setCapability("ie.ensureCleanSession", "true");

        return new InternetExplorerDriver(options);
    }
}

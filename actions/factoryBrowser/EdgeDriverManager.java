package factoryBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class EdgeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        // Edge chỉ chạy trên Windows hoặc Mac thôi
        if (!IS_OS_WINDOWS || !IS_OS_MAC) {
            throw new BrowserNotSupportedException("Edge is not supported on" + System.getProperty("os.name"));

        }
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions() ;
        // Gọi options vì sau này cần setting gì
        return new EdgeDriver(options);

    }
}

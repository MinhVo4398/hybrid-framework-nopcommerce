package eclipseTips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_03_Getter_Setter {
	// Global

	WebDriver driver;

	// Page Object Pattern

	@Test
	public void Login_01_Email_Empty() {
		driver = new FirefoxDriver();
	}

	@Test
	public void login_02_email_invalid() {
		// local
		WebDriver driver = null; // gọi biến local luôn luôn khởi tạo nó
		driver.get(""); // luôn luôn gọi biến local để xài

		this.driver.get(""); // còn muốn xài biến driver global thì phải thông qua từ khoá this
	}

}

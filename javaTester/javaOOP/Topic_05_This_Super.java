package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_05_This_Super extends BaseOOP {
	// Global
	private WebDriver driver;
	public long shortTimeout =15;
	protected long longTimeout = 45; 
	
	public Topic_05_This_Super() {
		// Luôn luôn gọi qua Constructor của Class cha
		super("Chrome");
		System.out.println("Constructor cua Class con");
	}
	
	public void setImplicitWait() {
		
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		
		System.out.println(super.browserName);
		
		
	}
	
	public void clickToElement() {
		// Ko dùng super nó sẽ gọi qua ở Class con (lớp hiện tại)
		setImplicitWait();
		
		// Gọi hàm ở lớp Cha
		super.setImplicitWait();
	}
	
	
	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();
	}

}

package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseOOP extends SeleniumWebDriver {
	public long shortTimeout =15;
	protected long longTimeout = 45;
	private WebDriver driver;
	
	
	public BaseOOP() {
		System.out.println("Constructor tại Class cha");
	}
	public BaseOOP(String name) {
		System.out.println("Constructor tại Class cha" + name);
	}
	public BaseOOP(int number) {
		System.out.println("Constructor tại Class cha" + number);
	}
	
	public void setImplicitWait() {
		// Local
		long shortTimeout = 15;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		
	}
	
	
}

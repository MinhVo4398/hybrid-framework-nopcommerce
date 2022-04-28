package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP {
	// Global
	private WebDriver driver;
	public long shortTimeout =15;
	protected long longTimeout = 45; 
	
	public void setImplicitWait() {
		// Local
		long shortTimeout = 15;
		
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);
	}
	
	
	public static void main(String[] args) {
		
	}

}

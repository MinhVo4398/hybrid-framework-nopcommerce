package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_06_Condition_Statement {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	//@Test
	public void TC_01_IF () {
		boolean status = 5 <3;
		System.out.println(status);
		// Hàm if sẽ nhận vào 1 điều kiện đúng
		//  Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện đúng thì sẽ action (xxx) trong phần thân
		if (status) {
			System.out.println("Go to if");
		}
		
		// Gán (assgin)
		int studentNumber = 10;
		
		//  == So sánh
		status = (studentNumber == 10);
		System.out.println(status);

		
		WebDriver driver = new FirefoxDriver();
		WebElement salePopUp = driver.findElement(By.id(""));
		
		//Element luôn luôn có trong DOM dù popup hiển thị hay ko
		if(salePopUp.isDisplayed()) {
			
		}
		
		//Element ko có trong DOM khi popup ko hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		//Check element ko hiển thị
		if(salePopups.size()>0 && salePopups.get(0).isDisplayed()) {
			
			
		}
		
		//Uncheck to checkbox -dc chọn thì click
		WebElement languagesCheckbox =  driver.findElement(By.id(""));
			
		if(languagesCheckbox.isSelected()) { 
			languagesCheckbox.click();
		}
		
		//Check to checkbox - chưa dc chọn thì click
		if (!languagesCheckbox.isDisplayed()) {
			languagesCheckbox.click();
		}
	}
	
	//@Test
	public void TC_02_If_Else() {
		// Có tới 2 điều kiện: nếu đúng thì vào if - sai thì vào else
		
		// Nếu driver start vs browser như Chrome/Firefox/Edge/Safari thì dùng hàm click thông thường (builtin) của Selenium
		
		//Nếu driver là IE thì dùng hàm click của JavascriptExecutor
//		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
//		
		 
	
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println(driver.toString()); //InternetExplorerDriver: internet explorer on WINDOWS (fa8a7cce-ca02-4161-b81f-f0ad09592891)
		if(driver.toString().contains("internet explorer")) {
			System.out.println("Click  by Javascript Executor");
		}
		else {
			System.out.println("Click by Selenium WebElement");
		}
		
		
	}
	
	@Parameters("browser")
	//@Test
	public void TC_03_If_Else_If_Else(String browserName) {

		// Có nhiều điều kiện
		// Best Practice: ko nên if-else quá nhiều
		
		if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else { // Safari/Opera/Coccoc/...
			throw new RuntimeException("Please input correct the browswe name!");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		
		driver.quit();
		
	}
	
	@Test
	public void TC_04_If_Else_If_Else() {
		// Page Object
		// Dynamic Page
		String pageName = "Login";
		if (pageName.equals("Login")) {
			
			// LoginPage loginPage = new LoginPage;
			//return loginPage
		} else if(pageName.equals("Register")) {
			// RegisterPage registerPage = new RegisterPage();
			//return registerPage

		}
		 else if(pageName.equals("New Customer")) {
		// CustomerPage customerPage = new CustomerPage();
		//return CustomerPage

		 }
		else {
			//HomePage homePage = new HomePage();
			//return homePage;
		}
		
		//ìf-else
		int age =20;
		String access = (age<18) ? "You can not access" : "Welcome to our system";
	}
	
}

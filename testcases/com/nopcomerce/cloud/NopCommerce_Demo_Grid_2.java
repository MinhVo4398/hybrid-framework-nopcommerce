package com.nopcomerce.cloud;


import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;


public class NopCommerce_Demo_Grid_2 extends BaseTest {
	//Declare
	private WebDriver driver;

	private  String  firstName, lastName, validPassword, emailAddress;

	//Declare + Init
	private 	UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	
	

	@Parameters({"browser", "url", "ipAddress", "portNumber"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl, String ipAddress, String portNumber) {
		
		driver = getBrowserDriverGrid(browserName,appUrl,ipAddress,portNumber);
		
		// Khởi tạo homePage lên trước
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		firstName ="Automation";
		lastName ="FC";		
		emailAddress = "afc"+ generateFakeNumber()+ "@mail.vn";
		validPassword ="123456";	
		
	
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page ");
		registerPage= homePage.openRegisterPage(); // B= A.action
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input to Firstname textbox" + firstName );
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is "+ lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is "+ emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is "+ validPassword);
		registerPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is "+ validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();


		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	
		
	
	}
	

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to login page ");
		homePage =	registerPage.clickToLogoutLink();
		loginPage =	homePage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to email textbox " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to password textbox " + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button ");
		homePage = loginPage.clickToLoginButton();


		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify My Account Link Displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Open My Account page");
		customerInforPage = homePage.openMyAccountPage();
		
	
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify Customer page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}





}

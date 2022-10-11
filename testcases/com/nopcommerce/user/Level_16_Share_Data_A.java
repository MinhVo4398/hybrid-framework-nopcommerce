package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {
	//Declare
	private WebDriver driver;
	private  String  validPassword, emailAddress;

	private UserHomePageObject homePage ;
	private UserLoginPageObject loginPage;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriverGrid(browserName);
		
		// Khởi tạo homePage lên trước
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		validPassword = Common_01_Register_End_User.emailAddress;
		emailAddress = Common_01_Register_End_User.password;
		
		log.info("Login - Step 01: Navigate to Login Page ");
		loginPage =	homePage.openLoginPage();
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + validPassword +"' ");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03: Enter to Email textbox ");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - Step 04: Click to Login button ");
		homePage = loginPage.clickToLoginButton();

	
	}


	@Test
	public void Search_01_Empty_Data() {
		

	
	}
	@Test
	public void Search_02_Relative () {
		

	
	}
	@Test
	public void Search_03_Absolute_Product_Name() {
		

	
	}
	@Test
	public void Search_04_Parent_Category() {
		

	
	}
	@Test
	public void Search_05_Incorrect_Manufacturer() {
		

	
	}
	@Test
	public void Search_06_Correct_Manufacturer() {
		

	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}





}

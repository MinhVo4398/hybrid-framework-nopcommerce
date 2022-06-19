package com.livetechpanda;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.techpanda.AccountDashboardPageObject;
import pageObjects.techpanda.HomePageObject;
import pageObjects.techpanda.LoginPageObject;
import pageObjects.techpanda.PageGenerator;
import pageObjects.techpanda.RegisterPageObject;



public class LiveTech extends BaseTest {
	private String firstName, lastName, emailAddress, passWord, confirmPassword;	
		
	
	//Declare
	private WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	AccountDashboardPageObject accountDashboardPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		emailAddress = "afc"+ generateFakeNumber() + "@mail.com";
		firstName = "Minh";
		lastName ="Vo";
		passWord ="123456789";
		confirmPassword ="123456789";
		
		driver = getBrowserDriver(browserName, appUrl);
		//driver lấy xong ở hàm trên map vô getHomePage
		
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_Register_Account() {
			//homePage click To MyAccountLink -> Login Page
		loginPage = homePage.openMyAccountLink();
		
		//loginPage click CreateAnAccountButton -> RegisterPage
		registerPage =	loginPage.clickToCreateAnAccountButton();
		
		registerPage.inputToFirstNameTextBox("Minh");
		registerPage.sleepInSecond(2);
		registerPage.inputToLastNameTextBox("Vo");
		registerPage.sleepInSecond(2);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.sleepInSecond(2);
		registerPage.inputToPasswordTextBox("123456789");
		registerPage.sleepInSecond(2);
		registerPage.inputToConfirmPasswordTextBox("123456789");
		registerPage.sleepInSecond(2);
		
		//registerPage click to registerButton -> AccountDashboardPage
		accountDashboardPage	 = registerPage.clickToRegisterButton();
		Assert.assertEquals(accountDashboardPage.getSuccessMessageText(), "Thank you for registering with Main Website Store.");
		
		
	}
	
	


	@AfterClass
	public void afterClass() {
	//	driver.quit();

	}

	public void generateFakeEmail() {
		Random rd =new Random();
	}



}

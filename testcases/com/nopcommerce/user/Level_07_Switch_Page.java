package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	//Declare
	private WebDriver driver;

	private  String  firstName, lastName, validPassword, emailAddress;

	//Declare + Init
	private 	UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	
	
	private String projectPath = System.getProperty("user.dir"); // lấy ra đường dẫn

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriverLocal(browserName);
			
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		firstName ="Automation";
		lastName ="FC";		
		emailAddress = "afc"+ generateFakeNumber()+ "@mail.vn";
		validPassword ="123456";	
		
	
	}

	@Test
	public void User_01_Register() {
		
		
		registerPage= homePage.openRegisterPage(); // B= A.action
	
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		System.out.println(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");


		homePage =	registerPage.clickToLogoutLink();

			
	}

	@Test
	public void User_02_Login() {
		
		loginPage =	homePage.openLoginPage();
		
		
			
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
	
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}

	@Test
	public void User_03_Customer_Infor() {
			
		customerInforPage = homePage.openMyAccountPage();
		
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

	}
	@Test
	public void User_04_Switch_Page() {
		// Knowledge của Page Object:
		// Một page A khi chuyển qua page B thì phải viết hàm
		//(action: open/click/...: link/button/image/...) để mở page B đó lên
		
		//Customer Infor -> Address
		
	addressPage = customerInforPage.openAddressPage(driver);
		// Address -> My Product Review
	myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	
		
		// My Product Review -> Reward Point
	rewardPointPage = myProductReviewPage.openRewardPoint(driver);
		
		//Reword Point -> Address
	addressPage = rewardPointPage.openAddressPage(driver);
		
		//Address -> Reward Point
	rewardPointPage = addressPage.openRewardPoint(driver);
		
		//Reward Point -> My Product Review
		
	myProductReviewPage =  rewardPointPage.openMyProductReviewPage(driver);
	
		// My Product Review -> Address
	addressPage = myProductReviewPage.openAddressPage(driver);
	
	customerInforPage =	addressPage.openCustomerInforPage(driver);
	
	myProductReviewPage =	customerInforPage.openMyProductReviewPage(driver);
	

	}
	
	@Test
	public void User_05_Switch_Role() {
		//Role User -> Role Admin
		 
		//Role Admin -> Role User

	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();

	}





}

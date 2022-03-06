package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.AddressPageObject;
import pageObjects.nopCommerce.CustomerInforPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyProductReviewPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	//Declare
	private WebDriver driver;

	private  String  firstName, lastName, validPassword, emailAddress;

	//Declare + Init
	private 	HomePageObject homePage ;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInforPageObject customerInforPage;
	private AddressPageObject addressPage;
	private MyProductReviewPageObject myProductReviewPage;
	private RewardPointPageObject rewardPointPage;
	
	
	private String projectPath = System.getProperty("user.dir"); // lấy ra đường dẫn

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
			
		homePage = PageGeneratorManager.getHomePage(driver);
	
		firstName ="Automation";
		lastName ="FC";		
		emailAddress = "afc"+ generateFakeNumber()+ "@mail.vn";
		validPassword ="123456";	
		
	
	}

	@Test
	public void User_01_Register() {
		
		
		registerPage= homePage.clickToRegisterLink(); // B= A.action
	
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
		
		loginPage =	homePage.clickToLoginLink();
		
		
			
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
	
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}

	@Test
	public void User_03_Customer_Infor() {
			
		customerInforPage = homePage.clickToMyAccountLink();
		
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

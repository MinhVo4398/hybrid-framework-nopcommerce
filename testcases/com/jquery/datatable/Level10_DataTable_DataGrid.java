package com.jquery.datatable;


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

public class Level10_DataTable_DataGrid extends BaseTest {
	//Declare
	private WebDriver driver;


	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	
		
	
	}

	@Test
	public void Table_01() {
		
	
	}
	@Test
	public void Table_02() {
		
	}
	
	
	@Test
	public void User_03_Dynamic_Page_01() {
		
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		
		
		
	}



	@AfterClass
	public void afterClass() {
		driver.quit();

	}





}

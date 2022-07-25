package com.facebook.register;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGenerator;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;

	private LoginPageObject loginPage;
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		// Nếu 1 cái hàm chỉ mong đợi verify element displayed thôi- kết hợp cả wait + isDisplay
		//waitForElementVisible
		//isElementDisplayed
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

	}
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Nếu như mình mong đợi 1 hàm vừa verify displayed / undisplayed thì k dc kết hợp wait
		// Vì waitForElementVisible ko đúng trong trường hợp element undisplayed
		
		//Verify True - mong đợi Confirm Email display
		
		// Verify False - mong đợi Confirm Email Undisplayed
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplay());
		
	

	}
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		

	}
	
	

	@AfterClass
	public void afterClass() {
		 driver.quit();

	}

}

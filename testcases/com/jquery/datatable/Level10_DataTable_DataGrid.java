package com.jquery.datatable;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObjects.jQuery.PageGeneratorManager;
import pageObjects.jQuery.HomePageObject;


public class Level10_DataTable_DataGrid extends BaseTest {
	
	HomePageObject homePage;
	//Declare
	private WebDriver driver;


	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		//driver lấy xong ở hàm trên map vô getHomePage
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(3);
		
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(3);
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);
	}
	@Test
	public void Table_02() {
		
	}
	
	
		



	@AfterClass
	public void afterClass() {
		driver.quit();

	}





}

package com.jquery;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;


public class Level_11_Upload_Files extends BaseTest {
	

	private WebDriver driver;


	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		
	}
	@Test
	public void Upload_01_One_File_Per_Time() {
		
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		
	}
	
	

	@AfterClass
	public void afterClass() {
		//driver.quit();

	}





}

package com.wordpress.admin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;



public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	//Declare
	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO admninDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	String searchPostUrl ;
	
	String adminUsername ="automationfc";
	String adminPassword ="automationfc";
	

	@Parameters({"browser", "urlAdmin"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin URL");
		driver = getBrowserDriver(browserName,adminUrl);		
	//	adminLoginPage = new AdminLoginPO(driver); // Cách thông thường
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value : " + adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value :" + adminPassword);
		
		
		log.info("Pre-Condition - Step 04:	Click to Login button");
		
		admninDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
		
		
		
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01:Click to 'Post' menu link");
		searchPostUrl ="";
		
		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);
		
		log.info("Create_Post - Step 02:Click to 'Add New' button ");
		
		adminPostAddNewPage = PageGeneratorManager.getAdminPostAddNewPage(driver);
		
		
				
		log.info("Create_Post - Step 03: Enter to post title ");
		
		log.info("Create_Post - Step 04: Enter to body ");
		
		log.info("Create_Post - Step 05: Click to 'Publish ' button ");
		
		log.info("Create_Post - Step 06: Verify 'Post published' message is displayed ");
		
		
		
		
	}
	

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page ");
		// Open searchPostUrl
		
		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);
		
		
	}
	
	@Test
	
	public void Post_03_View_Post() {
		
	}
	
	@Test
	public void Post_04_Edit_Post() {
		
	}
	
	@Test
	public void Post_05_Delete_Post() {
		
	}
	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver();
	}






}

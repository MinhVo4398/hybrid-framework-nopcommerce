package com.wordpress.admin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;



public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	//Declare
	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO admninDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	String searchPostUrl ;
	int randomNumber =  generateFakeNumber();
	String postTitle ="Live Coding Title " + randomNumber;
	String postBody ="Live Coding Body " + randomNumber;
	String authorName ="automationfc";
	String adminUsername ="automationfc";
	String adminPassword ="automationfc";
	String adminUrl, endUserUrl;
	String currentDay= getCurrentDay();

	@Parameters({"browser", "urlAdmin","urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and Admin site");
		this.adminUrl = adminUrl;
		this.endUserUrl =endUserUrl;
		driver = getBrowserDriver(browserName,this.adminUrl);		
	//	adminLoginPage = new AdminLoginPO(driver); // Cách thông thường
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value : " + adminUsername);
		adminLoginPage.enterToUserNameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value :" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04:	Click to Login button");
		admninDashboardPage =	adminLoginPage.clickTologinButton();
		
	//	admninDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);  -> dua vao clicklogin, roi dung gián lại value, ko có việc khởi tạo trên TC nữa
		
		
		
		
		
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01:Click to 'Post' menu link");
	
		
		adminPostSearchPage =	admninDashboardPage.clickToPostMenuLink();
		
	
		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver) ;  // lấy url của page hiện tại
		
		
		log.info("Create_Post - Step 03:Click to 'Add New' button ");		
		adminPostAddNewPage =	adminPostSearchPage.clickToAddNewButton();
		
		
				
		log.info("Create_Post - Step 04: Enter to post title ");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05: Enter to body ");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post - Step 06: Click to 'Publish ' button ");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 07: Click to 'Pre-publish ' button ");
		adminPostAddNewPage.clickToPreBulishButton();
		
		log.info("Create_Post - Step 08: Verify 'Post published' message is displayed ");
		verifyTrue(adminPostAddNewPage.isPostPubishMessageDisplay("Post published."));
		
		
		
	}
	

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page ");
		// Open searchPostUrl
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Search_Post - Step 02: Enter to Search textbox ");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search_Post - Step 03: Click to 'Search Posts' button ");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Search_Post - Step 04: Verify Search table contains ' " + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",postTitle));
		
		log.info("Search_Post - Step 05: Verify Search table contains ' " + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		log.info("Search_Post - Step 06: Open User site ");
		userHomePage = adminPostSearchPage.openEndUserSite(driver,this.endUserUrl); // sau này trang admin bất kì vị trí nào cũng có thể mở dc endUser ra 
		
		log.info("Search_Post - Step 07: Verify Post Infor displayed at Home Page ");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle,postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle,authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle,currentDay));
		
		log.info("Search_Post - Step 08: Click to Post Title ");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		log.info("Search_Post - Step 09: Verify Post infor displayed at Post detail Page ");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle,postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle,authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(postTitle,currentDay));
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

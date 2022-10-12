package com.wordpress.admin;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.*;


public class User_01_View_User extends BaseTest {
    //Declare
    private WebDriver driver;
    AdminLoginPO adminLoginPage;
    AdminDashboardPO admninDashboardPage;
    AdminUserPO adminUserPage;

    String searchPostUrl;
    int randomNumber = generateFakeNumber();

    String adminUsername = "automationfc";
    String adminPassword = "automationfc";
    String adminUrl, endUserUrl;
    String currentDay = getCurrentDay();

    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
        log.info("Pre-Condition - Step 01: Open browser and Admin site");
        this.adminUrl = adminUrl;
        this.endUserUrl = endUserUrl;
        driver = getBrowserDriver(browserName, this.adminUrl);
        //	adminLoginPage = new AdminLoginPO(driver); // Cách thông thường
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Pre-Condition - Step 02: Enter to Username textbox with value : " + adminUsername);
        adminLoginPage.enterToUserNameTextbox(adminUsername);

        log.info("Pre-Condition - Step 03: Enter to Password textbox with value :" + adminPassword);
        adminLoginPage.enterToPasswordTextbox(adminPassword);

        log.info("Pre-Condition - Step 04:	Click to Login button");
        admninDashboardPage = adminLoginPage.clickTologinButton();

        //	admninDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);  -> dua vao clicklogin, roi dung gián lại value, ko có việc khởi tạo trên TC nữa


    }

    @Test
    public void TC_01_View_User() {
        log.info("View_User - Step 01:Click to 'Post' menu link");
        adminUserPage = admninDashboardPage.clickToUserMenuLink();

        log.info("View_User - Step 02:Get all users from UI");
        int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();
        System.out.println("Total number on UI=" + totalNumberUserAtUI);

        log.info("View_User - Step 03:Get all users from DB");
        int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();
        System.out.println("Total number on DB=" + totalNumberUserAtDB);

        log.info("View_User - Step 04: Verify the User are matching");
        verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);

        //	adminUserPage.checkTotalRecordMemorySizeFromDB("Computer","20", "roleAdmin");
        // adminUserPage.checkTotalRecordMemorySizeFromDB("Computer","20", "roleAdmin");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver();
    }


}

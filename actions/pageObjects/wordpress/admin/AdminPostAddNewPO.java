package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;
	
	public   AdminPostAddNewPO (WebDriver driver) {
			this.driver = driver;

	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX,postTitleValue);
		
	}
	public void enterToAddNewPostBody(String postBodyValue) {
		//Click  business phai click cho nháy chuột rồi mới click dc
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		
		//SendKey
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);	
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX,postBodyValue);
		
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		
	}

	public void clickToPreBulishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		
	}
	public boolean isPostPubishMessageDisplay(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		 return  isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return  PageGeneratorManager.getAdminPostSearchPage(driver);
		
	}

	

}

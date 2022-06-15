package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		// Trường hợp dùng tham số phải dùng hàm có truyền tham số động
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver,HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextBoxByLabel(String headerLabel, String value) {
		// wait ko sendkey nên ko truyền value vào
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		// hàm này dynamic value (headerLabel) truyền sau cùng
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL,value, headerLabel);
		
	}
	
	

}

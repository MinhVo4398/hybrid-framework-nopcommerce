package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
		
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVIED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVIED_BY_NUMBER, pageNumber);
		
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size =" + totalPage);
		// Khai báo 1 ArayList
		List<String> allRowValuesAllPage = new ArrayList<String>();
		
		//  Dùng vòng lặp duyệt qua tất cả các page number(paging), ko có page 0
		for (int index = 1; index <= totalPage; index++) {
			// hàm này chỉ nhân tham số dynamic là chuỗi -> convert index(int) qua String -> dùng Strign valueof
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			//Get text của all row mỗi page đưa vào cái ArrayList
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());// getTex mỗi row lưu vào list
				//eachRow.getText(); // getTex mỗi row lưu vào list
			}
			
			
		}
		// In tất cả giá trị row ra- tất cả các page 
		for (String value : allRowValuesAllPage) {
			System.out.println("---------------");
			System.out.println(value);
			
		}
		return allRowValuesAllPage;
	}
	
	

}

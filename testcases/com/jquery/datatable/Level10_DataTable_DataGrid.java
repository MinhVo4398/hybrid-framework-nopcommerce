package com.jquery.datatable;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;


public class Level10_DataTable_DataGrid extends BaseTest {
	
	HomePageObject homePage;
	List<String> actualAllCountryValues ;
	List<String> expectedAllCountryValues ;
	//Declare
	private WebDriver driver;


	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		//driver lấy xong ở hàm trên map vô getHomePage
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1); 
		// Dựa vào sự thay đổi ở element html để verify cho phù hợp
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
	}
	
	public void Table_02_Enter_To_Header() {
		// refresh để tránh dữ liệu bị cache lại
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextBoxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextBoxByLabel("Females", "338282");
		homePage.enterToHeaderTextBoxByLabel("Males", "349238");
		homePage.enterToHeaderTextBoxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		
		homePage.enterToHeaderTextBoxByLabel("Country", "Angola");
		homePage.enterToHeaderTextBoxByLabel("Females", "276880");
		homePage.enterToHeaderTextBoxByLabel("Males", "276472");
		homePage.enterToHeaderTextBoxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
	}
	
	
	public void Table_03_Enter_To_Header() {
		// YC: Lấy ra tất cả row hoặc 1 row hoặc 1 tiêu chí 1 cột nào đó thôi (dựa vào locator để lọc ra)
		// Đọc dữ liệu của file country.txt ra
		// Lưu vào 1 List<String> =Expected value =expectedAllCountryValues
		
		//Actual Value
		actualAllCountryValues =	homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	
		
	@Test
	public void Table_04_Action_At_Any_Row() {
		//demo trên trang https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
		// Nhâp value tại cột nào đó và dòng nào đó bất kì
		// Column name:Album /Artist /Year - tham số 1
		// Row number:tại row nào  - tham số 2
		//Ex: Nhập vào textbox tại dòng số 3/5/7
		// Value để nhập dữ liệu (Micheal 97( - tham số 3 )
		homePage.enterToTextboxByColumnNameAtRowNumber("Album","1", "Micheal 97");
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","1", "Micheal Jackson");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year","1", "1997");
		homePage.enterToTextboxByColumnNameAtRowNumber("Price","1", "15");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Japan");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Hong Kong");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","US");
		homePage.sleepInSecond(3);
	}
	


	@AfterClass
	public void afterClass() {
		//driver.quit();

	}





}

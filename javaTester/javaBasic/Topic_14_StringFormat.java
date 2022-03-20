package javaBasic;

public class Topic_14_StringFormat {
	//14 pages = 14 biến locator
	public static  String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static  String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static  String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static  String CUSTOMER_INFOR_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	
	//1 biến cho cả 14 page hoăc n page (format giống nhau - chỉ khác nhau bởi tên page)
	
	public static  String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	public static void main(String[] args) {
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Customer info");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
		
		
	}
	
	public static void clickToSideBarLink(String locator) {
		System.out.println("Click to: "+ locator);
		
	}
	
	public static void clickToSideBarLink(String dynamicLocator, String pageName) {
		// dynamicLocator = //div[contains(@class,'account-navigation')]//a[text()='%s']
		//pageName= Customer Info	
		String locator =String.format(dynamicLocator, pageName);
																															
		System.out.println("Click to: "+ locator);
		
	}
}

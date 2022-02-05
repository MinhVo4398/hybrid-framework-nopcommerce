package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {
		//Primitive type/ value type : Nguyên thuỷ
	byte bNumber = 127;
	
	short sNumber = 1500;
	
	int iNumber = 65000;
	
	long lNumber =65000;
	
	float fNumber= 15.98f;
	
	double dNumber= 15.98d;
	 
	char cChar ='1';
	
	boolean bStatus = true ;
	
		//Reference type: tham chiếu
	
	//String
	String address = " Ho Chi Minh";
	
	//Array
	
	String[] studentAddress = {address, "Ha Noi" , "Da Nang"};
	Integer[] studentNumber = {15, 20, 50};
	
	
	//Class
	
	Topic_02_Data_Type topic;
	
	//Interface
	WebDriver driver;
	
	//Object -> có thể convert qua Class, Int, Float, String.. dc
	Object aObject;
	
	
	//Collection
	// List/ Set/ Queue / Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));  // List k lưu trùng data 
	Set<String> allWindows = driver.getWindowHandles(); // Set cho lưu trùng data
	
	List<String> productName  = new ArrayList<String>();
	
 	
	public void clickToElement() {
		address.trim();
		
		studentAddress.clone();
		
		driver.getCurrentUrl();
		
		aObject.toString();
		
		homePageLinks.size();
		
		allWindows.clear();
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		topic.address = "Ha Noi";
		
	}
	
	public static void main(String[] args) {
		
	}

}

package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For_Each {
	
	WebDriver driver;
	@Test
	public void TC_01_For_Iterate() {
		// In ra 5 lần
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		
		System.out.println("=================================");
		for (int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
//		List<WebElement> links = driver.findElement(By.id(""));
//		links.size();
		
		// Array
		 String[] cityName = {"Ha Nội", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};
		 // 4
		 
		 //Array / List / Set / Queue (index)
		 
		 // For kết hợp if: Thoả mãn điều kiện mới action
		 // Biến đếm - dùng như điều kiện để filter
		 
		 for (int i =0; i <cityName.length; i++) {

			 if(cityName[i].equals("Da Nang")) {
				 // Action
				 System.out.println("Do action!");
				 break;
			 }
		 }
		 
		 
		 for (int i =0; i <cityName.length; i++) {

			 if(cityName[i].equals("Da Nang")) {
				 // Action
				 System.out.println("Do action!");
				
			 }
			 //Tất cả các giá trị (element) đều dc chạy qua dù đã thoả mãn điều kiện rồi -> gẫy lãng phí
		 }
		
		
		 // Dùng để chạy qua hết các giá trị
		 for (String city : cityName) {
			System.out.println(city);
		}
	}
	
	
	@Test
	public void TC_02_For_Each() {
		
		//Array
		String [] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};
		
		
		
		//Java Collection
		//Class: ArrayList / LinkedList / Vector/...
		//Interface: List/ Set / Queue
		
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());  // 0
		
		
		//Compile (Coding)
		cityAddress.add("Bắc Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sapa");
		
		System.out.println(cityAddress.size());  // 3
		//Runtime(Running)
		for (String city : cityName) {
			cityAddress.add(city);
		}
		
		System.out.println(cityAddress.size());  //9
		
		
		for (String cityAdd : cityAddress) { 
			System.out.println(cityAdd);
		}
		
		// Java Generic
		List<WebElement> links = driver.findElements(By.xpath("/a"));
		
		// Xử lý dữ liệu/ get text/value/css/attribute
		for (WebElement link : links) {
			//Chuyển page
			//Refresh DOM/ HTML
			//Không còn tồn tại
			//Fail ->StaleElementException
		}
		
	
	}
	
	
}

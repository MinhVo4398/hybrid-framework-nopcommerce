package javaBasic;

import org.testng.annotations.Test;

import commons.GlobalConstants;

public class Topic_11_Array_Exercise {
	int[] number = {5,8,15,60,10};
	@Test
	public void TC_01_Find_max() {

		
		int n =0;
		for (int i = 0; i < number.length; i++) {
			if(n<number[i]) {
				n=number[i];
			}
		}
		System.out.println("Phan tu lon nhat trong mang la: "+ n);
		
	}

	@Test
	public  void TC_02_Find_Sum_First_And_Last_Number() {
		int x=0;
		for (int i=0; i<number.length; i++) {
			x=number[0] + number[number.length-1];

		}
		System.out.println("Sum of First and Last Number: "+ x);

	}

	@Test
	public void TC_03() {
		for (int i = 0; i <number.length ; i++) {
			if(number[i] %2 ==0) {
				System.out.println("Even number =" +number[i]);
			}
			
		}
	}

	@Test
	public  void TC_04() {
		for (int i=0; i<number.length; i++) {
			if(number[i] >0 && number[i] <10) {
				System.out.println("Number in (0<number<10) = "+number[i]);
			}
		}

	}

		@Test
		public void TC_05() {
			int sum =0;
			for (int i=0; i<number.length; i++) {
				sum+=number[i];
			}
			System.out.println("Sum all number = "+ sum);
			System.out.println("Avarage all number = "+ sum/number.length);
		}
		
	@Test
	public void TC_06() {
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName ="";
		String [] fileNames ={"CScharp.jpg","Java.png","Python.png"};
		for (String file : fileNames) {
			fullFileName = fullFileName +filePath + file +"\n";
			
		}
		fullFileName =fullFileName.trim();
		System.out.println(fullFileName);
	}
	
}

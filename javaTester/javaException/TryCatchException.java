package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class TryCatchException {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		try {
				int array[] = new int[10];
				array[10] = 30/0;
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
		}
	
		FileOutputStream outputStream =null;
		try {
			 outputStream = new FileOutputStream("C://automationfc.txt");
			outputStream.write(65);
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		sleepInSecond(10);
		
	}
	
	public static void sleepInSecond(long timeout) throws InterruptedException {
			Thread.sleep(timeout *1000);
	}

}

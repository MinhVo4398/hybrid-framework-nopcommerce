package javaBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Topic_05_Reference_Casting {
	
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("studentName = "+studentName);
	}
	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new 	Topic_05_Reference_Casting();
		Topic_05_Reference_Casting scondStudent = new 	Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Nguyen Van Nam");
		scondStudent.setStudentName("Le Van Long");
		
			firstStudent.showStudentName();
			scondStudent.showStudentName();
		
		// Ép kiểu
		firstStudent = scondStudent;
		
		firstStudent.showStudentName();
		scondStudent.showStudentName();
		
		scondStudent.setStudentName("Dao M Dam");
		firstStudent.showStudentName();
		scondStudent.showStudentName();
		
		
		WebDriver driver = null;
		
		JavascriptExecutor jsExecutor =(JavascriptExecutor) driver;
	}
}

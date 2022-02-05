package javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {
	//Constructor - Hàm khởi tạo (k có kiểu trả về và có tên trùng tên với tên class)
	public Topic_01_Variable() {
		String studentName;
	}
	
	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome"; // constant
	
	static int studentPrice;
	
 protected String studentName = "Automation FC"; // biến global 
	
	public static void main(String[] args) {
		int studentPrice = 5;
		
		System.out.println(studentNumber);
		System.out.println(statusValue);
		System.out.println(studentPrice);
		
		System.out.println(Topic_01_Variable.BROWSER_NAME); // Biến static được truy cập từ tên class đến tên biến
		System.out.println(Topic_01_Variable.statusValue); // Biến static được truy cập từ tên class đến tên biến
		System.out.println(Topic_01_Variable.studentPrice); // Biến static được truy cập từ tên class đến tên biến
		
		Topic_01_Variable topic_1 = new Topic_01_Variable();
		Topic_01_Variable topic_2 = new Topic_01_Variable();
		Topic_01_Variable topic_3 = new Topic_01_Variable();
		System.out.println(topic_1.studentName); // muốn dùng biến student name k phải satic phải khởi tạo 1 đối tượng và truy cập thông qua đối tượng thì dc
		System.out.println(topic_2.studentName);
		System.out.println(topic_3.studentName);
			
		
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);
				
		}
	//Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ getPosition/...
	public String getStudentNumber() {
		return this.studentName;
	}
	
	//Setter: click/senkey/clear/select/back/forward/refresh/ get/...
	public void setStudentName(String sdtName) {
		this.studentName = sdtName;
	}
	
	
}

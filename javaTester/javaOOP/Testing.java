package javaOOP;

public class Testing {
	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		
		// Instance variable
		firstStudent.studentID = 1564564;
		
		// có thể truy cập trực tiếp từ tên class tới tên biến
		System.out.println(Topic_02_Variable_Property_Method.studentAddress);
		
		Topic_02_Variable_Property_Method.studentAddress ="Ha Noi";
		
		
	}
		
}

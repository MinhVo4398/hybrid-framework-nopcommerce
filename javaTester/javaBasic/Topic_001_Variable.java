package javaBasic;

public class Topic_001_Variable {
	// Global variable
 static	int number;
 
 String address ="Ho Chi Minh";

	public static void main(String[] args) {
		// Local variable
		int studentNumber = 0;
		
		// biến static number khai báo ngoài hàm nên mới gọi dc, nếu k có chữ static gọi k dc biến này(number)
		System.out.println(number); 
		
		
		// Còn muốn truy cập 1 biến k phải static (address) thì phải thông qua đối tượng 
		Topic_001_Variable topic = new Topic_001_Variable();
		System.out.println(topic.address);
		
		//	System.out.println(studentNumber); báo lỗi vì biến local muốn dùng phải khởi tạo dữ liệu
		System.out.println(studentNumber);

	}

}

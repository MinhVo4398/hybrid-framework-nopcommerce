package javaOOP;

public class Topic_02_Variable_Property_Method {
	
	static int studentNumber;
	static float studentPrice;
	static String studentCountry;
	 static boolean studentStatus;
	
	// Access Modifier
	// Data type
	// Variable name
	// Variable value
	private String studentName = "Automation FC"; // Biến toàn cục (Global variable)
	
	
	//Static variable
	public static String studentAddress ="Ho Chi Minh";
	
	//Dùng trong phạm vi Class này( cho tất cả instance/object dùng)
	private static String studentPhone = "098754321";
	
	// Final variable: Không cho phép gán lại / overide lại
	// Cố định dữ liệu không cho phép thay đổi trong quá trình chạy
	final String country ="Viet Nam";
	
	
	// Static final variable: hằng số (Constant)
	// Nó không dc ghi đè
	// Có thể truy cập rộng rãi cho tất cả các instance/ thread
	static final float PI_NUMBER =3.14245f;
	
	// Access modifier: default
	int studentID = 1005;
	
	public static void main(String[] args) {
		// Local variable - biến cục bộ: hàm
		String studentName = "Automation FC";

		if (studentName.startsWith("Automation")) {
			// Local variable - biến cục bộ: block code
			int number = 100;
		}
		
		// có thể truy cập trực tiếp (trong hàm static), ko cần phải khởi tạo đối tượng
		studentAddress ="Da Nang";
		studentPhone = "0983396037";
		
		// Local variable: bắt buộc phải khởi tạo mới dc sử dụng
	
		System.out.println(studentNumber); // 0 (default)
		System.out.println(studentCountry); // null
		System.out.println(studentStatus); //false
		System.out.println(studentPrice); //0.0 (default)
		
		
	}
	
	// Constructor
	public Topic_02_Variable_Property_Method() {
		// Local variable - biến cục bộ: constructor
		String studentName = "Automation FC";
		
		
	}

	// Hàm (Method) - non static
	public void display() {
		// Local variable - biến cục bộ: hàm
		String studentName = "Automation FC";
	}

}

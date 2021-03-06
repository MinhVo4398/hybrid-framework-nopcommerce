package javaOOP;

public final class Topic_04_Non_Access_Modifier {
	// Static: Variable/Method
	// Dùng cho tất cả các instance / object
	// Phạm vi cho toàn bộ system sử dụng nó
	// Có thể override được
	
	static String browserName= "Chrome";
	
	// Non static
	String serverName = "Testing";
	
	// Hằng số
	final String colorCar = "Red";
	
	final static String REGISTER_BUTTON = "";
	
	public static void main(String[] args) {
		
		
		System.out.println(browserName);
		
		browserName ="Firefox";
		System.out.println(browserName);
		
				
//		Topic_04_Non_Access_Modifier  topic = new Topic_04_Non_Access_Modifier();
//		System.out.println(topic.serverName);
//		
//		// Không được phép gán lại giá trị
//		System.out.println(topic.colorCar);
		
//		topic.colorCar ="Black";  nó k cho phép gán lại
		
		//topic.clickToElement("Button");  // hàm non-static phải gọi thông qua object/instance mới dùng dc
		sendkeyToElement("Link"); // hàm static có thể gọi trực tiếp ra dùng
	}
	
	
	// Non static
	public void clickToElement(String elementName) {
		System.out.println(elementName);
	}
	
	//Static
	
	public static void sendkeyToElement(String elementName) {
		System.out.println(elementName);
	}
	
	//Final Method
	public final void setCarName() {
		 	
	}
}

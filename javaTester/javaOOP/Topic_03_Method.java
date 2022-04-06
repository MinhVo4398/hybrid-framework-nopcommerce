package javaOOP;

public class Topic_03_Method {
	
	// Non-satic
	 void showCarName() {
		System.out.println("Huyndai Tucson");
	}
	 
	static void showCarColor() {
		 System.out.println("White");
	 }
	

	public static void main(String[] args) {
		// Gọi vào trong 1 hàm static khác được
		showCarColor();
		
	//	showCarName(); ko gọi dc
		
		// Gọi qua instance/ object mới dùng dc
		
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName();
		
		showCarColor(); // cách gọi 1
		Topic_03_Method.showCarColor(); // cách gọi 2, trực tiếp từ tên class tới tên biến
	}

}

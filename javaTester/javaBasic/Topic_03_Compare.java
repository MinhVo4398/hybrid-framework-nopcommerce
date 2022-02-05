package javaBasic;

public class Topic_03_Compare {
	
	int number = 8;

	public static void main(String[] args) {
		// 1 vùng nhớ cho biến x
		int x= 5;
		
		// 1 vùng nhớ cho biến y
		int y = x;
		
		System.out.println("x =" + x); // 5
		System.out.println("y =" + y); //5
		
		y = 10;
		System.out.println("x =" + x); //5 , x là 1 vùng nhớ, y là 1 vùng nhớ, khi thằng y dc cập nhật thì nó k liên quan tới xs
		System.out.println("y =" + y); //10
		
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		
		Topic_03_Compare secondVariable = firstVariable; // gán second = first, second tham chiếu tới vùng nhớ number chung vs first
		
		// Nhưng nếu Topic_03_Compare secondVariable = new Topic_03_Compare(); thì second sẽ tham chiếu 1 vùng nhớ khác và lúc này nó khác nhau
		
		System.out.println("Before = " + firstVariable.number);  // 8
		System.out.println("Before = " + secondVariable.number);  // 8
		
		secondVariable.number = 15;
		
		System.out.println("After = " + firstVariable.number);  // 15 vì nó là tham chiếu
		System.out.println("After = " + secondVariable.number);  // 15
	}

}

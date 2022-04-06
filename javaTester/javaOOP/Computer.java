package javaOOP;

public abstract class Computer {
	 
	// Normal Method
	public void showComputerPerformance() {
		System.out.println("Show Computer performance");
	}
	
	// Abstract Method
	// Khung để cho các Class con kế thừa nó phải override lại (implement) lại
	public abstract void showComputerRam();
	
	
	
	
		


}

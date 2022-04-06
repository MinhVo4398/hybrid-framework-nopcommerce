package javaOOP;

public interface IComputer {
	
//	// Normal Method - Interface k dc phép chứa method thường
//		public void showComputerPerformance() {
//			System.out.println("Show Computer performance");
//		}
	
	// Nếu ko gán từ khoá là abstract cho hàm thì tự hiểu đây vẫn là 1 hàm abstract
	public void showComputerPerformance();
	
	// Abstract Method
	public abstract void showComputerRam();

}

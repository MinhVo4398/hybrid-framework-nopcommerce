package javaOOP.overriding;

public class Employee extends Person implements IWork {
	public void eat() {
		System.out.println("Suất cơm 25.000");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 6 tiếng 1 ngày");
	}

	@Override
	public void workingTime() {
		System.out.println("Hoc 7 tieng 1 ngay");
		
	}
}

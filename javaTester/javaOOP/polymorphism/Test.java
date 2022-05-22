package javaOOP.polymorphism;

public class Test {
	public static void main(String[] args) {
		Annimal ani = new Annimal();
		ani.eat();
		
		ani = new Pig();
		ani.eat();
	}

}

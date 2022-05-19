package javaOOP.inheritance;

public class Runable {
	
	public Runable() {
		System.out.println("Parent's Constructor");
	}
	public Runable(String name) {
		System.out.println("Parent's Constructor-" + name);
	}
	public Runable(String name, String age) {
		System.out.println("Parent's Constructor-" + name);
		System.out.println("Parent's Constructor-" + age);
	}
}

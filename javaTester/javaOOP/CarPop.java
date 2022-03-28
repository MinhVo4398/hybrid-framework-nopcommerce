package javaOOP;

public class CarPop {
	
	// Nested class
	public class Head {
		
	}
	
	public interface ICar{
		
	}
	
static	String carCompany;
static	 String carType;
static	String fuelType;
static	Float mileAge;
static	Double carPrice;
	
	
	
	public static void main(String[] args) {
		carCompany = "Honda";
		carType ="City";
		fuelType = "Petrol";
		mileAge = 200f;
		carPrice = 50000d;
		
		System.out.println("Car company =" + carCompany );
		System.out.println("Car Type =" + carType );
		System.out.println("Fuel Type  =" + fuelType );
		System.out.println("Mile Age =" + mileAge );
		System.out.println("Car Price =" + carPrice );
		
		carCompany = "Huyndai";
		carType ="Accent";
		fuelType = "Diesel";
		mileAge = 150f;
		carPrice = 30000d;
		
		System.out.println("Car company =" + carCompany );
		System.out.println("Car Type =" + carType );
		System.out.println("Fuel Type  =" + fuelType );
		System.out.println("Mile Age =" + mileAge );
		System.out.println("Car Price =" + carPrice );
		
		
		 
	}
	
	
	
	

}

package javaOOP;

public class CarOOP {
	// Thuộc tính
	private	String carCompany;
	private	String carType;
	private String fuelType;
	private	 Float mileAge;
	private Double carPrice;
	
	

	public CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
		super();
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}



	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Float getMileAge() {
		return mileAge;
	}

	public void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	public Double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}
	
	protected void showCarInfor() {

		System.out.println("Car company =" + getCarCompany() );
		System.out.println("Car Type =" + getCarType() );
		System.out.println("Fuel Type  =" + getFuelType() );
		System.out.println("Mile Age =" + getMileAge() );
		System.out.println("Car Price =" + getCarPrice() );
	}
	
	public static void main(String[] args) {
		//Honda
		CarOOP honda = new CarOOP("Honda", "City", "Petrol", 150f, 50000d);		
		honda.showCarInfor();
		
		// Toyota
		CarOOP toyota = new CarOOP("Toyota", "Camry", "Diesel", 200f, 60000d);		
		toyota.showCarInfor();
		
		
		
	}
}

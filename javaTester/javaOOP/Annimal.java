package javaOOP;

	// Abstract Class
	//Template
public abstract class Annimal {
	
	//Variable
String annimalName = "Dog";	
	
	//Method
	// Không có phần thân (body)
	// public, protected
	// Bắt buộc các class con phải overide các hàm này lại
public	abstract void setAnnimalName();

}

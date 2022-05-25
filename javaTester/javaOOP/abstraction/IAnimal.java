package javaOOP.abstraction;

public interface IAnimal {
		public final int SUM_NUMBER = 1000;
		String getName();
		
		void setName(String name);
		
		abstract String getAddress();
		
		abstract void setAddress(String address);

}

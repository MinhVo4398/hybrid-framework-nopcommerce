package javaBasic;

public class Topic_05_Primitive_Casting {

	public static void main(String[] args) {
		
		// Ép kiểu ngầm định (không mất dữ liệu)
//		byte bNumber = 126;
//		System.out.println(bNumber);
//	
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//		
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//		
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//		
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//		
//		double dNumber = fNumber;
//		System.out.println(dNumber);
		
		// Ép kiểu tường minh (Cast)
	double	dNumber =654321789;
	System.out.println(dNumber);
	
	float fNumber = (float) dNumber; // từ lớn qua nhỏ
	System.out.println(fNumber);
	
	long lNumber = (long) fNumber;
	System.out.println(lNumber);
	
	int iNumber = (int) lNumber;
	System.out.println(iNumber);

	}

}

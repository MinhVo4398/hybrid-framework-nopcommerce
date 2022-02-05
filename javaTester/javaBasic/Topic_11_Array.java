package javaBasic;

import java.util.ArrayList;

public class Topic_11_Array {
	public static void main(String[] args) {

		int number[] = { 12, 7, 5, 61, 15 };

		int[] student = { 12, 7, 5, 61, 15 };

		// Lấy ra phần tử đầu tiên
		System.out.println(student[0]);
		System.out.println(student[1]);

		// Cố định
		// Được define cố định bao nhiêu phần tử khi mình viết code (Complie )
		String studentName[] = { "Nam", "Long", "An" };
		studentName[0] = "Hoa";

		for (int i = 0; i < studentName.length; i++) {

			if (studentName[i].equals("Long")) {
				System.out.println(studentName[i]);
			}

		}

		// Không kết hợp với điều kiện
		for (String std : studentName) {

			if (std.equals("Long")) {
				System.out.println("Click vào Long");
			}

		}
		// Động
		ArrayList<String> stdName = new ArrayList<>();

		// Khi chạy code mới add (Runtime)
		for (String std : studentName) {
			stdName.add(std);
		}

	}

}

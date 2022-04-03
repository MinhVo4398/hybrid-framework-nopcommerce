package javaOOP;

public class Topic_01_Class_Object_Student {
	

	public int studentID;
	private String studentName;
	private float knowdledgePoint;
	private float practicePoint;
	
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public float getKnowdledgePoint() {
		return knowdledgePoint;
	}


	public void setKnowdledgePoint(float knowdledgePoint) {
		this.knowdledgePoint = knowdledgePoint;
	}


	public float getPracticePoint() {
		return practicePoint;
	}


	public void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getAveragePoint() {
		return (this.knowdledgePoint + this.practicePoint *2)/3;
	}
	
	private void showStudentInfor() {
		System.out.println("**********************");
		System.out.println("Student ID =" + getStudentID());
		System.out.println("Student Name =" + getStudentName());
		System.out.println("Student Knowdelge Point =" + getKnowdledgePoint());
		System.out.println("Student Practice Point =" + getPracticePoint());
		System.out.println("Student Avarage Point="+ getAveragePoint());
		System.out.println("**********************");
		
	}
	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		
		// Instance variable
		firstStudent.studentID = 1564564;
		
		
		firstStudent.setStudentID(2005206);
		firstStudent.setStudentName("John Terry");
		firstStudent.setKnowdledgePoint(8.0f);
		firstStudent.setPracticePoint(7.8f);		
		firstStudent.showStudentInfor();
		
		
		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
		secondStudent.setStudentID(2005207);
		secondStudent.setStudentName("Michael Jackson");
		secondStudent.setKnowdledgePoint(9.5f);
		secondStudent.setPracticePoint(8.5f);		
		secondStudent.showStudentInfor();
		
		
		
	}

}

package com.student.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	public String studentId;
	public String studentName;
	public String studentClass;
	public float studentTotalMarks;
	
	public Student() {
	}
	
	public Student(String studentId, String studentName, String studentClass, float studentTotalMarks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentTotalMarks = studentTotalMarks;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public float getStudentTotalMarks() {
		return studentTotalMarks;
	}
	public void setStudentTotalMarks(Float studentTotalMarks) {
		this.studentTotalMarks = studentTotalMarks;
	}
}


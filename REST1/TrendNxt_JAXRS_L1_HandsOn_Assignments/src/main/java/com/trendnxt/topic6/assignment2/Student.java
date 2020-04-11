package com.trendnxt.topic6.assignment2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private String studentId;
	private String studentName;
	private String studentClass;
	private Float studentTotalMarks;
	
	public Student() {
	}
	
	public Student(String studentId, String studentName, String studentClass, Float studentTotalMarks) {
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
	public Float getStudentTotalMarks() {
		return studentTotalMarks;
	}
	public void setStudentTotalMarks(Float studentTotalMarks) {
		this.studentTotalMarks = studentTotalMarks;
	}
}

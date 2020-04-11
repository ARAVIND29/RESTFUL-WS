package com.trendnxt.topic7and8.assignment1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private String empId;
	private String empFirstName;
	private String empLastName;
	private String empLocation;
	private String empBand;
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empLocation=" + empLocation + ", empBand=" + empBand + "]";
	}

	public Employee(String empId, String empFirstName, String empLastName, String empLocation, String empBand) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empLocation = empLocation;
		this.empBand = empBand;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public String getEmpBand() {
		return empBand;
	}
	public void setEmpBand(String empBand) {
		this.empBand = empBand;
	}
	
	
}

package com.employee.restclient;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private String id;
	private String fname;
	private String lname;
	private String location;
	private String band;
	public Employee(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	@XmlElement
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	@XmlElement
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLocation() {
		return location;
	}
	@XmlElement
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBand() {
		return band;
	}
	@XmlElement
	public void setBand(String band) {
		this.band = band;
	}
}

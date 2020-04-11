package com;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class MainEmployee {

	public static void main(String[] args) {
		Client cl1=ClientBuilder.newClient();
		//Display all employees method
		List<Employee> empList=cl1.target("http://localhost:8080/Assignment21/rest/employee/display").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Employee>>() {});
		for(Employee e:empList) {
			System.out.println("Employee id : "+e.getId());
			System.out.println("First Name : "+e.getFname());
			System.out.println("Last Name : "+e.getLname());
			System.out.println("Location : "+e.getLocation());
			System.out.println("Band : "+e.getBand());
			System.out.println("-----------------------");
		}
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
		cl1.close();
		Client cl2=ClientBuilder.newClient();
		//Display employees with given band
		List<Employee> empListByBand=cl2.target("http://localhost:8080/Assignment21/rest/employee/band/b2").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Employee>>() {});
		for(Employee e:empListByBand) {
			System.out.println("Employee id : "+e.getId());
			System.out.println("First Name : "+e.getFname());
			System.out.println("Last Name : "+e.getLname());
			System.out.println("Location : "+e.getLocation());
			System.out.println("Band : "+e.getBand());
			System.out.println("-----------------------");
		}
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
		cl2.close();
		Client cl3=ClientBuilder.newClient();
		//Display employees with given location
		List<Employee> empListByLocation=cl3.target("http://localhost:8080/Assignment21/rest/employee/loc/Pune").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Employee>>() {});
		for(Employee e:empListByLocation) {
			System.out.println("Employee id : "+e.getId());
			System.out.println("First Name : "+e.getFname());
			System.out.println("Last Name : "+e.getLname());
			System.out.println("Location : "+e.getLocation());
			System.out.println("Band : "+e.getBand());
			System.out.println("-----------------------");
		}
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
		cl3.close();
		//Trying delete function
		Client cl4=ClientBuilder.newClient();
		List<Employee> empDelete=cl4.target("http://localhost:8080/Assignment21/rest/employee/delete/e001").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Employee>>() {});
		
	}

}

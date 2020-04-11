package com.trendnxt.topic7and8.assignment2;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.trendnxt.topic7and8.assignment1.Employee;

public class EmployeeServiceRestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		
		WebTarget webTarget = client.target("http://localhost:8080/Jersey/rest").path("employees");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		List<Employee> listOfEmployees = response.readEntity(new GenericType<List<Employee>>() {});
		System.out.println(response.getStatus());
		listOfEmployees.stream().forEachOrdered(System.out::println);
		
		response = client.target("http://localhost:8080/Jersey/rest").path("employeesByEmpLocation/London")
				.request(MediaType.APPLICATION_XML).get();
		listOfEmployees = response.readEntity(new GenericType<List<Employee>>() {});
		System.out.println(response.getStatus());
		listOfEmployees.stream().forEachOrdered(System.out::println);
		response = client.target("http://localhost:8080/Jersey/rest").path("employeesByEmpBand/B1")
				.request(MediaType.APPLICATION_XML).get();
		listOfEmployees = response.readEntity(new GenericType<List<Employee>>() {});
		System.out.println(response.getStatus());
		listOfEmployees.stream().forEachOrdered(System.out::println);
		
		
		Employee emp = new Employee("EM006", "Test","Client","Pune","B2");
		response = client.target("http://localhost:8080/Jersey/rest").path("employee")
				.request(MediaType.APPLICATION_XML).post(Entity.entity(emp, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		emp.setEmpFirstName("TEST");
		emp.setEmpLastName("CLIENT");
		response = client.target("http://localhost:8080/Jersey/rest").path("employee")
				.request(MediaType.APPLICATION_XML).put(Entity.entity(emp, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		response = client.target("http://localhost:8080/Jersey/rest").path("employee/E006")
				.request(MediaType.APPLICATION_XML).delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}

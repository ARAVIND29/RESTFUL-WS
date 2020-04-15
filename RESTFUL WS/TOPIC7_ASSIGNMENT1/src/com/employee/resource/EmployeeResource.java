package com.employee.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.employee.dao.EmpDao;
import com.employee.model.Employee;

@Path("employee")
public class EmployeeResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("display")
	public List<Employee> getAll(){
		EmpDao c=new EmpDao();
		return c.getAll();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("band/{band}")
	public List<Employee> getEmployeeByBand(@PathParam("band") String band){
		EmpDao c=new EmpDao();
		return c.getEmployeeByBand(band);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("loc/{location}")
	public List<Employee> getEmployeeByLocation(@PathParam("location") String location){
		EmpDao c=new EmpDao();
		return c.getEmployeeByLocation(location);
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	@Path("add")
	public Response addEmployee(Employee emp) {
		EmpDao c=new EmpDao();
		if(c.addEmployee(emp)==1) 
			return Response.ok(emp).build();
		return Response.status(400).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	@Path("update/{empid}")
	public Response updateEmployee(@PathParam("empid") String id,Employee e) {
		e.setId(id);
		EmpDao c=new EmpDao();
		if(c.updateEmployee(e)==1) 
			return Response.ok(e).build();
		return Response.status(400).build();
	}
}

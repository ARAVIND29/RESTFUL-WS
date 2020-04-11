package com.trendnxt.topic7and8.assignment1;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDao();

	@GET
	@Path("/employees")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Employee> getEmployees() throws SQLException {
		return employeeDao.getAllEmployee();
	}

	@GET
	@Path("/employeesByEmpLocation/{empLocation}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Employee> getEmployeeByEmpLocation(@PathParam("empLocation") String empLocation) throws SQLException {
		return employeeDao.getAllEmployee().stream().filter(e -> empLocation.equalsIgnoreCase(e.getEmpLocation()))
				.collect(Collectors.toList());
	}

	@GET
	@Path("/employeesByEmpBand/{empBand}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Employee> getEmployeeByEmpBand(@PathParam("empBand") String empBand) throws SQLException {
		return employeeDao.getAllEmployee().stream().filter(e -> empBand.equalsIgnoreCase(e.getEmpBand()))
				.collect(Collectors.toList());
	}

	@POST
	@Path("/employee")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_XML)
	public Response addEmployee(Employee emp)  {
		int i = 0;
		try {
			i = employeeDao.addEmployee(emp);
		}catch(SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Un-able to add Employee").build();
		}
		if (i > 0)
			return Response.status(Response.Status.CREATED).entity("Employee added sussefully").build();
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Un-able to add Employee").build();
	}

	@PUT
	@Path("/employee")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateEmployee(Employee emp) {
		int i = 0;
		try {
			i = employeeDao.updateEmployee(emp);
		}catch(SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Un-able to update Employee").build();	
		}
		
		if (i > 0)
			return Response.status(Response.Status.OK).entity("Employee updated sussefully").build();
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Un-able to update Employee").build();
	}

	@DELETE
	@Path("/employee/{empId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response deleteEmployee(@PathParam("empId") String empId) throws SQLException {
		return Response.status(Response.Status.NOT_IMPLEMENTED).build();
	}
}

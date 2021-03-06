package com;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("student")
public class StudentRes {
	
	@GET
	@Path("display")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> stlist(){
		Controller cont=new Controller();
		return cont.getAll();
	}
	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("id") String sid) {
		Controller c=new Controller();
		return c.getStudentById(sid);
	}
	@GET
	@Path("{marks}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> stmarks(@PathParam("marks") int mark){
		Controller c=new Controller();
		return c.getStudentByMarks(mark);
	}
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addStudent(@FormParam("id") String id,@FormParam("name") String name,@FormParam("class") String cls,@FormParam("marks") int marks) {
		Controller c=new Controller();
		Student st=new Student();
		st.setId(id);
		st.setName(name);
		st.setsClass(cls);
		st.setMarks(marks);
		if(c.addStudent(st) == 1) return Response.ok("Insertion Successful").build();
		return Response.status(400).build();
	}
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateStudent(@FormParam("id") String id,@FormParam("name") String name,@FormParam("class") String cls,@FormParam("marks") int marks) {
		Controller c=new Controller();
		Student st=new Student();
		st.setId(id);
		st.setName(name);
		st.setsClass(cls);
		st.setMarks(marks);
		if(c.updateStudent(st) == 1) return Response.ok("Updation Successful").build();
		return Response.status(400).build();
	}
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudentById(@PathParam("id") String sid) {
		Controller c=new Controller();
		if(c.deleteStudent(sid) == 1) return Response.ok("Deletion Successful").build();
		return Response.status(400).build();
	}
}

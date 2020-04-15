package com.wipro.resource;

import java.util.List;
import java.util.stream.Collectors;

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

import com.wipro.dao.StudentDao;
import com.wipro.model.Student;

@Path("/students")
public class StudentResource  {

	
	@GET
	@Path("/all")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	public List<Student> getStudents()
	{
		return StudentDao.instance.getModel(); 
	}
	
	
	@GET
	@Path("/student/{sid}")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	public Student getStudent(@PathParam("sid") String sid)
	{
		return StudentDao.instance.getModel().stream().filter(s -> sid.equalsIgnoreCase(s.getStudentId())).collect(Collectors.toList()).get(0);
	}
	
	@GET
	@Path("/smarks/{marks}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudentOrderByMarks(@PathParam("marks") float marks) {
		return StudentDao.instance.getModel().stream().filter(s -> s.getStudentTotalMarks() > marks).collect(Collectors.toList());
	}
	
	@POST
	@Path("/sadd")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String addStudent(@FormParam("studentId") String studentId,
			@FormParam("studentName") String studentName, @FormParam("studentClass") String studentClass,
			@FormParam("studentTotalMarks") float studentTotalMarks) throws Exception {
		Student student = new Student(studentId, studentName, studentClass, studentTotalMarks);
		boolean studentExists = false;
		for (Student s : StudentDao.instance.getModel()) {
			if (studentId.equalsIgnoreCase(s.getStudentId())) {
				studentExists = true;
			}
		}
		if (!studentExists) {
			StudentDao.instance.getModel().add(student);
		}
		return "<html><body bgcolor=seagreen><h1>!!!!SUECCESSFULLY INSERTED RECORD!!!!!</h1></body></html>";
	}
	
	@PUT
	@Path("/supdate")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Student> updateStudent(@FormParam("studentId") String studentId,
			@FormParam("studentName") String studentName, @FormParam("studentClass") String studentClass,
			@FormParam("studentTotalMarks") Float studentTotalMarks) {

		for (Student student : StudentDao.instance.getModel()) {
			if (studentId.equalsIgnoreCase(student.getStudentId())) {
				student.setStudentClass(studentClass);
				student.setStudentName(studentName);
				student.setStudentTotalMarks(studentTotalMarks);
			}
		}
		return StudentDao.instance.getModel();
	}
	
	@DELETE
	@Path("/sdelete/{studentId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> removeStudent(@PathParam("studentId") String studentId) {
		Student student = StudentDao.instance.getModel().stream().filter(s -> studentId.equalsIgnoreCase(s.getStudentId())).collect(Collectors.toList()).get(0);
		StudentDao.instance.getModel().remove(student);
		return StudentDao.instance.getModel();
	}
	
	
	
}

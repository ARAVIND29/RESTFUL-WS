package com.student.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.student.dao.StudentDao;
import com.student.model.Student;

@Path("/students")
public class StudentResource {

	StudentDao dao  = new StudentDao();
	@GET
	@Path("/sclass")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudents(@MatrixParam("studentClass") String studentClassMatrix,@QueryParam("studentClass") String studentClassQuery) {

		String Class = null;
		if (studentClassQuery != null) {
			Class = studentClassQuery;
		} else if (studentClassMatrix != null) {
			Class = studentClassMatrix;
		}
		if (Class != null) {
			String sc = Class;
			return dao.getModel().stream().filter(s -> sc.equalsIgnoreCase(s.getStudentClass())).collect(Collectors.toList());
		}
		return dao.getModel();
	}
	
	@GET
	@Path("/all/{studentClass}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudentsByClass(@PathParam("studentClass") String studentClass) {
		return dao.getModel().stream().filter(s -> studentClass.equalsIgnoreCase(s.getStudentClass())).collect(Collectors.toList());
	}
	
	@GET
	@Path("/student")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student getStudentByQueryMatrix(@MatrixParam("studentId") String studentIdMatrix,@QueryParam("studentId") String studentIdQuery) {
		String sId = null;
		if (studentIdMatrix != null) {
			sId = studentIdMatrix;
		} else if (studentIdQuery != null) {
			sId = studentIdQuery;
		}

		if (sId != null) {
			String si = sId;
			return dao.getModel().stream().filter(s -> si.equalsIgnoreCase(s.getStudentId())).collect(Collectors.toList()).get(0);
		}

		return null;
	}

	@GET
	@Path("/orderByMarks/{marks}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudentOrderByMarks(@PathParam("marks") float marks) {
		return dao.getModel().stream().filter(s -> s.getStudentTotalMarks() > marks).collect(Collectors.toList());
	}
	
}

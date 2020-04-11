package com.trendnxt.topic6.assignment2;

import java.util.ArrayList;
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

@Path("/")
public class StudentService {

	private static List<Student> students = init();

	private static List<Student> init() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("S001", "Steve Martin", "C1", 90f));
		students.add(new Student("S002", "Steve Martin", "C1", 45f));
		students.add(new Student("S003", "Steve Martin", "C1", 55f));
		students.add(new Student("S004", "Steve Martin", "C1", 85f));
		students.add(new Student("S005", "Steve Martin", "C1", 36f));
		students.add(new Student("S006", "Steve Martin", "C2", 89f));
		students.add(new Student("S007", "Steve Martin", "C2", 95f));
		students.add(new Student("S008", "Steve Martin", "C2", 56f));
		students.add(new Student("S009", "Steve Martin", "C2", 65f));
		students.add(new Student("S010", "Steve Martin", "C2", 45f));
		return students;
	}

	@GET
	@Path("/students")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudents() {
		return students;
	}

	@GET
	@Path("/student/{studentId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student getStudent(@PathParam("studentId") String studentId) {
		return students.stream().filter(s -> studentId.equalsIgnoreCase(s.getStudentId())).collect(Collectors.toList())
				.get(0);
	}

	@GET
	@Path("/students/orderByMarks/{marks}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudentOrderByMarks(@PathParam("marks") float marks) {
		return students.stream().filter(s -> s.getStudentTotalMarks() > marks).collect(Collectors.toList());
	}

	@POST
	@Path("/student")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Student> addStudent(@FormParam("studentId") String studentId,
			@FormParam("studentName") String studentName, @FormParam("studentClass") String studentClass,
			@FormParam("studentTotalMarks") Float studentTotalMarks) {
		Student student = new Student(studentId, studentName, studentClass, studentTotalMarks);
		boolean studentExists = false;
		for (Student s : students) {
			if (studentId.equalsIgnoreCase(s.getStudentId())) {
				studentExists = true;
			}
		}
		if (!studentExists) {
			students.add(student);
		}
		return students;
	}

	@PUT
	@Path("/student")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Student> updateStudent(@FormParam("studentId") String studentId,
			@FormParam("studentName") String studentName, @FormParam("studentClass") String studentClass,
			@FormParam("studentTotalMarks") Float studentTotalMarks) {

		for (Student student : students) {
			if (studentId.equalsIgnoreCase(student.getStudentId())) {
				student.setStudentClass(studentClass);
				student.setStudentName(studentName);
				student.setStudentTotalMarks(studentTotalMarks);
			}
		}
		return students;
	}
	
	@DELETE
	@Path("/student/{studentId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> removeStudent(@PathParam("studentId") String studentId) {
		Student student = students.stream().filter(s -> studentId.equalsIgnoreCase(s.getStudentId())).collect(Collectors.toList())
				.get(0);
		students.remove(student);
		return students;
	}

}

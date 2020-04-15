package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;

public class StudentDao {
	
	 List<Student> data = new ArrayList<Student>();
	 
	 public StudentDao()
	 {
		 	data.add(new Student("S1","Aravind","A",90f));
			data.add(new Student("S2","Vishnu","A",80f));
			data.add(new Student("S3","Siva","B",70f));
		 
	 }
	 	
	public  List<Student> getModel()
	{
		return data;
	}

}

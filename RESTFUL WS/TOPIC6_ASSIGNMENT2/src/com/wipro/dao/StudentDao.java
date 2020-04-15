package com.wipro.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.model.Student;

public enum StudentDao {
	instance;
	
	private List<Student> data = new ArrayList<Student>();
	
	private StudentDao()
	{
		Student s1 = new Student("s1","aravind","A",90.0f);
		Student s2 = new Student("s2","krishna","B",80.0f);
		Student s3 = new Student("s3","ravi","A",50.0f);
		Student s4 = new Student("s4","ram","B",75.0f);
		Student s5 = new Student("s5","lilly","B",60.0f);
		data.add(s1);
		data.add(s2);
		data.add(s3);
		data.add(s4);
		data.add(s5);
	}
	
	public List<Student> getModel()
	{
		return data;
	}
	
}

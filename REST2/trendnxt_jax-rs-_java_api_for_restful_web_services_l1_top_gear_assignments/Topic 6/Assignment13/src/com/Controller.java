package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	Connection con=null;
	public Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
		return con;
	}
	public List<Student> getAll() {
		List<Student> stlist=new ArrayList<>();
		try {
			con=this.connect();
		PreparedStatement ps=con.prepareStatement("Select * from student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Student s=new Student();
			s.setId(rs.getString(1));
			s.setName(rs.getString(2));
			s.setsClass(rs.getString(3));
			s.setMarks(rs.getInt(4));
			stlist.add(s);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stlist;
	}
	public Student getStudentById(String id) {
		Student s=new Student();
		try {
			con=this.connect();
			PreparedStatement ps=con.prepareStatement("Select * from student where id=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s.setId(rs.getString(1));
				s.setName(rs.getString(2));
				s.setsClass(rs.getString(3));
				s.setMarks(rs.getInt(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public List<Student> getStudentByMarks(int marks){
		List<Student> stlist=new ArrayList<>();
		try {
			con=this.connect();
		PreparedStatement ps=con.prepareStatement("Select * from student where marks>?");
		ps.setInt(1, marks);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Student s=new Student();
			s.setId(rs.getString(1));
			s.setName(rs.getString(2));
			s.setsClass(rs.getString(3));
			s.setMarks(rs.getInt(4));
			stlist.add(s);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stlist;
	}
	public int addStudent(Student st) {
		int i=0;
		try {
			con=this.connect();
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setString(1, st.getId());
			ps.setString(2, st.getName());
			ps.setString(3, st.getsClass());
			ps.setInt(4, st.getMarks());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public int updateStudent(Student st) {
		int i=0;
		try {
			con=this.connect();
			PreparedStatement ps=con.prepareStatement("update student set name=?,class=?,marks=? where id=?");
			ps.setString(4, st.getId());
			ps.setString(1, st.getName());
			ps.setString(2, st.getsClass());
			ps.setInt(3, st.getMarks());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public int deleteStudent(String id) {
		int i=0;
		try {
			con=this.connect();
			PreparedStatement ps=con.prepareStatement("delete from student where id=?");
			ps.setString(1, id);
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public List<Student> getStudentByClass(String clas){
		List<Student> stlist=new ArrayList<>();
		try {
			con=this.connect();
		PreparedStatement ps=con.prepareStatement("Select * from student where class=?");
		ps.setString(1, clas);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Student s=new Student();
			s.setId(rs.getString(1));
			s.setName(rs.getString(2));
			s.setsClass(rs.getString(3));
			s.setMarks(rs.getInt(4));
			stlist.add(s);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stlist;
	}
}

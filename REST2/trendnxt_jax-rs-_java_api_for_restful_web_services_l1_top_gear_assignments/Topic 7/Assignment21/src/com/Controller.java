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
		public List<Employee> getAll() {
			List<Employee> stlist=new ArrayList<>();
			try {
				con=this.connect();
			PreparedStatement ps=con.prepareStatement("Select * from employee4");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee s=new Employee();
				s.setId(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setLocation(rs.getString(4));
				s.setBand(rs.getString(5));
				stlist.add(s);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return stlist;
		}
		public List<Employee> getEmployeeByLocation(String loc){
			List<Employee> emplist=new ArrayList<>();
			try {
				con=this.connect();
			PreparedStatement ps=con.prepareStatement("Select * from employee4 where location=?");
			ps.setString(1, loc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 Employee s=new Employee();
				s.setId(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setLocation(rs.getString(4));
				s.setBand(rs.getString(5));
				emplist.add(s);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return emplist;
		}
		public List<Employee> getEmployeeByBand(String band){
			List<Employee> emplist=new ArrayList<>();
			try {
				con=this.connect();
			PreparedStatement ps=con.prepareStatement("Select * from employee4 where band=?");
			ps.setString(1, band);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 Employee s=new Employee();
				s.setId(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setLocation(rs.getString(4));
				s.setBand(rs.getString(5));
				emplist.add(s);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return emplist;
		}
		public int addEmployee(Employee emp) {
			int i=0;
			try {
				con=this.connect();
				PreparedStatement ps=con.prepareStatement("insert into employee4 values(?,?,?,?,?)");
				ps.setString(1, emp.getId());
				ps.setString(2, emp.getFname());
				ps.setString(3, emp.getLname());
				ps.setString(4, emp.getLocation());
				ps.setString(5, emp.getBand());
				i=ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return i;
		}
		public int updateEmployee(Employee emp) {
			int i=0;
			try {
				con=this.connect();
				PreparedStatement ps=con.prepareStatement("update employee4 set fname=?,lname=?,location=?,band=? where id=?");
				ps.setString(5, emp.getId());
				ps.setString(1, emp.getFname());
				ps.setString(2, emp.getLname());
				ps.setString(3, emp.getLocation());
				ps.setString(4, emp.getBand());
				i=ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return i;
		}
}



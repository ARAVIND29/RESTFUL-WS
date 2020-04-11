package com.trendnxt.topic7and8.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2MemoryDatabase {

	private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    
    public static void insertWithStatement() throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE Employee(id varchar(255) primary key, empFirstName varchar(255), empLastName varchar(255), empLocation varchar(255), empBand varchar(255))");
            stmt.execute("INSERT INTO Employee(id, empFirstName, empLastName, empLocation, empBand) VALUES('EM001', 'Peter','Parker','London','B3')");
            stmt.execute("INSERT INTO Employee(id, empFirstName, empLastName, empLocation, empBand) VALUES('EM002', 'John','Chena','Delhi','B2')");
            stmt.execute("INSERT INTO Employee(id, empFirstName, empLastName, empLocation, empBand) VALUES('EM003', 'Steve','Rogers','Mumbai','B2')");
            stmt.execute("INSERT INTO Employee(id, empFirstName, empLastName, empLocation, empBand) VALUES('EM004', 'Boymkesh','Bakshi','Kolkata','B1')");
            stmt.execute("INSERT INTO Employee(id, empFirstName, empLastName, empLocation, empBand) VALUES('EM005', 'Ant','Man','London','B1')");

            ResultSet rs = stmt.executeQuery("select * from Employee");
            System.out.println("H2 In-Memory Database inserted through Statement");
            while (rs.next()) {
                System.out.println("Id " + rs.getString("id") + " Name " + rs.getString("empFirstName"));
            }

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}

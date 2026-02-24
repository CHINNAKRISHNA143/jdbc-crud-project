package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	
	
	public void addStudent(Student student){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		con = DBConnection.getConnection();
		String query = "INSERT INTO students(name,email,course,marks) VALUES(?,?,?,?)";
		
		try {
			 pstmt = con.prepareStatement(query);
			 pstmt.setString(1, student.getName());
			 pstmt.setString(2, student.getEmail());
			 pstmt.setString(3, student.getCourse());
			 pstmt.setDouble(4, student.getMarks());
			 
			 int res = pstmt.executeUpdate();
			 
			 System.out.println("Student Added successfully..!");
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	public void viewStudents() {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM students";
			stmt = con.createStatement();
			res = stmt.executeQuery(query);
			
			while(res.next()) {
				System.out.println(res.getInt("id")+"   "+res.getString("name")+"   "+res.getString("email")+"   "
						+res.getString("course")+"   "+res.getDouble("marks"));
			}
			
		 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






















package com.jdbc;

public class JDBCTest {
	public static void main(String[] args) {
		
		StudentDAO studentDao = new StudentDAO();
		
		Student s2 = new Student("Chinni","chinni@gmail.com","JAVA FULLSTACK",75);
		
		//studentDao.addStudent(s2);
		
		studentDao.viewStudents();
		
	}

}

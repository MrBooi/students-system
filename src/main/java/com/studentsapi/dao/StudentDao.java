package com.studentsapi.dao;

import java.util.List;

import com.studentsapi.model.Student;

public interface StudentDao { 
	void insert(Student student);
	
	void editStudent (Student student);
	
	void insertBatch(List<Student> students);
	
	List<Student>loadAllStudents();
	
	Student findByName(String name);  
	
	Student findbyStudentId(int studentId);
	
	boolean isNameExists(String name); 
	
	boolean deleteStudent (int id); 
	

}

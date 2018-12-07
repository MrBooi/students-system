package com.studentsapi.dao;

import java.util.List;

import com.studentsapi.model.Student;

public interface StudentDao { 
	void insert(Student student);
	
	void insertBatch(List<Student> students);
	
	List<Student>loadAllStudents();
	
	String findNameByID(long id);

}

package com.studentsapi.service;

import java.util.List;

import com.studentsapi.model.Student;

public interface StudentService {
	void insert(Student stud);
	void insertBatch(List<Student> students);
	void loadAllStudents();
	void getStudentById(int stud);
}

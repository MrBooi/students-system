package com.studentsapi.service;

import java.util.List;


import com.studentsapi.model.Student;

public interface StudentService {
	void insert(Student stud);
	void editProfile (Student student);
	void insertBatch(List<Student> students);
	Object loadAllStudents();
	Student getStudentByName(String name);
	Student getstudentProfile(int studentId);
	boolean isNameExists(String name);
	boolean deleteStudentById(int id);
}

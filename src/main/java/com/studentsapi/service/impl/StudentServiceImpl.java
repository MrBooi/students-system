package com.studentsapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsapi.dao.StudentDao;
import com.studentsapi.model.Student;
import com.studentsapi.service.StudentService;
@Service 

public class StudentServiceImpl implements StudentService{
     
	@Autowired StudentDao StudentDao;
	
	@Override
	public void insert(Student student) {
		StudentDao.insert(student);
		
	}

	@Override
	
	public void insertBatch(List<Student> students) {
	   	StudentDao.insertBatch(students);
		
	}

	@Override
	public Object loadAllStudents() {
		List<Student> listStudents = StudentDao.loadAllStudents();
	
		return  listStudents;
	}


	@Override
	public Student getStudentByName(String name) {
		Student found = StudentDao.findByName(name);
		return found;
	}

	@Override
	public boolean isNameExists(String name) {
	 return StudentDao.isNameExists(name);
	 
	}

	@Override
	public boolean deleteStudentById(int id) {
	return StudentDao.deleteStudent(id);
	 
	}

	@Override
	public void editProfile(Student student) {
		StudentDao.editStudent(student);
		
	}

	@Override
	public Student getstudentProfile(int studentId) {
		return StudentDao.findbyStudentId(studentId);
	}
}

package com.studentsapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsapi.dao.StudentDao;
import com.studentsapi.model.Student;
import com.studentsapi.service.StudentService;
@Service
public class studentServiceImpl implements StudentService{
     
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
	public void loadAllStudents() {
		List<Student> listStudents = StudentDao.loadAllStudents();
		for(Student stud: listStudents){
			System.out.println(stud.toString());
		}
		
	}

	@Override
	public void getStudentById(int id) {
		String name = StudentDao.findNameByID(id);
		System.out.println("Student's name = " + name);
		
	}

}

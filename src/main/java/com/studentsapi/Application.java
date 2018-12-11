package com.studentsapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.studentsapi.service.StudentScoreService;
import com.studentsapi.service.StudentService;


@SpringBootApplication
@ComponentScan("com.studentsapi.controller, com.studentsapi.service.impl, com.studentsapi.dao.impl")

public class Application  {

	@Autowired
	StudentService studentService;
	StudentScoreService studentScoreService;
	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Application.class, args);
//    StudentService studentService = context.getBean(StudentService.class); 
//    StudentScoreService studentScoreService = context.getBean(StudentScoreService.class);
      
//    studentService.loadAllStudents();
	 
	} 
	
	

}


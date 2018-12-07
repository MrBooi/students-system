package com.studentsapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.studentsapi.model.Student;
import com.studentsapi.service.StudentService;


@SpringBootApplication
@ComponentScan("com.studentsapi.controller, com.studentsapi.service.impl, com.studentsapi.dao.impl")

public class Application  {

	@Autowired
	StudentService studentService;
	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Application.class, args);
    StudentService studentService = context.getBean(StudentService.class);
      
//		 Student Student_1 = new Student();
//		 Student_1.setId(1);;
//		 Student_1.setName("Ayabonga");
//		 Student_1.setEmail("aya@gmail.com");
//		 
//		 studentService.insert(Student_1);
		 
//		Load All Customer and display
		studentService.loadAllStudents();
//		 
//		// Get Customer By Id
//			System.out.println("=============Get Student By Id");
//			stuService.getStudentById(Long.valueOf(1));
		System.out.println("Hello");
//		 
	} 
	
	

}


//@Autowired
//JdbcTemplate jdbcTemplate;
//
//@Override
//public void run(String... args) throws Exception {
	
//    log.info("Creating tables");
//
//    jdbcTemplate.execute("DROP TABLE IF EXISTS students");
//    jdbcTemplate.execute("CREATE TABLE students( id SERIAL, name text)");
//    
//
//    // Uses JdbcTemplate's batchUpdate operation to bulk load data
//    jdbcTemplate.update("INSERT INTO students(name) VALUES (?)", "Aya B");
//    jdbcTemplate.update("INSERT INTO students(name) VALUES (?)", "Luvuyo S");
//     int result = jdbcTemplate.queryForObject(
//    		 "SELECT COUNT(*) from students", Integer.class);
//     
//     System.out.println("here"+result);
     
//     SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
//     return namedParameterJdbcTemplate.queryForObject(
//         "SELECT FIRST_NAME FROM EMPLOYEE WHERE ID = :id", namedParameters, String.class);
    
    
	
//}

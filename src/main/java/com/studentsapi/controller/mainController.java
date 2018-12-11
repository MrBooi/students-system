package com.studentsapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentsapi.model.Score;
import com.studentsapi.model.Student;
import com.studentsapi.service.StudentScoreService;
import com.studentsapi.service.StudentService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class mainController {

	@Autowired 
	private StudentService studentsRepo;
	
	@Autowired
	private StudentScoreService studentScoreRepo;
   
class CallStatus {
	private boolean success;
	private String message;
	private  Object data;
	
	public CallStatus() {
		
	}
	
	
	
	public CallStatus(boolean status, String message) {
		super();
		this.success = status;
		this.message = message;
	}
	
	public CallStatus(boolean status, String message ,Object data) {
		super();
		this.success = status;
		this.message = message;
		this.data =data;
	}
	
	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	
}

 
@GetMapping("/get/all/students")
public Object getAllUsers () {
	return studentsRepo.loadAllStudents();
}


    
 @PostMapping("/add/new/student") 
 public @ResponseBody CallStatus addNewUser (@RequestBody Student student ) {
	 String name = student.getName();
	 if(studentsRepo.isNameExists(name)) {
		return	new CallStatus(false, "opps name already exist");
	 }
	 studentsRepo.insert(student);
	return  new CallStatus(true, "Successfuly added a student");
 }
    
 @PostMapping("/edit/student") 
 public @ResponseBody CallStatus edit (@RequestBody Student student ) {
//	 String name = student.getName();
//	 if(!studentsRepo.isNameExists(name)) {
//		 return  new CallStatus(false, "opps this name does not exist");
//	 }
	 studentsRepo.editProfile(student);
  	return  new CallStatus(true,"Succefully made changes to your profile");
 }
 
 @GetMapping("/find/by/name/{name}")
public CallStatus findByName(@PathVariable("name") String name) { 
	 if(!studentsRepo.isNameExists(name)) {
		 return  new CallStatus(false, "opps this name does not exist");
	 } 
	 
	
	 
	 return new  CallStatus(true,"Profile is found",studentsRepo.getStudentByName(name));  
	 }

 
 @GetMapping("/find/by/student/id/{id}")
public CallStatus findByStudentId(@PathVariable("id") int studentId) { 
	 return new  CallStatus(true,"sucessfully loaded your profile",studentsRepo.getstudentProfile(studentId));  
	 }

	


 @GetMapping("/remove/student/id/{id}")
public CallStatus removeStudent (@PathVariable("id") int id) {
   boolean studentsscoresDeleted = studentScoreRepo.deleteStudentScore(id);
   boolean isDeleted =  studentsRepo.deleteStudentById(id);
     if (studentsscoresDeleted || isDeleted) {
	  return new CallStatus(true,"successfuly deleted Student"); 	
	}
return new CallStatus(false,"opps we dont have that student");
 
}
 
// score API call  
 
 @GetMapping("/students/score/average")
 public CallStatus  avgScore() {
 return  new CallStatus(true,"Student is sucessfully deleted",studentScoreRepo.averageScore());
 }
 
 

 @PostMapping("/add/student/id/{student_id}/score/{score}") 
 public @ResponseBody CallStatus addstudentScore (
		 @PathVariable("student_id") int student_id,
		 @PathVariable("score") int score) {
	 studentScoreRepo.insertScore(student_id,score); 
  	return  new CallStatus(true,"Succefully added student score");
 }
 
 
@PostMapping("/capture/student/score")
public CallStatus capstureStore(@RequestBody Student student) {
	 int newScore =  student.getScore();
	 if(!studentsRepo.isNameExists(student.getName())) {
		 return  new CallStatus(false, "opps this name does not exist");
	 } 
	 int currentStudent = (int) studentsRepo.getStudentByName(student.getName()).getId();
	  if(currentStudent >0) {
		 int prevScore = studentScoreRepo.studentScore(currentStudent);
		
		 if(prevScore !=0) {
			 if(newScore > prevScore) {
				 studentScoreRepo.insertScore(currentStudent,newScore);
				  return new CallStatus(true,"you have improve!!!");
			  } else if(newScore < prevScore) {
				  studentScoreRepo.insertScore(currentStudent,newScore);
				  return new CallStatus(true,"opps have drop!!!");
			  } 
				 if(newScore==prevScore) {
					 studentScoreRepo.insertScore(currentStudent,newScore);
					 return new CallStatus(true,"same score!!!");
		   }
		 }
			 
	  }
	  studentScoreRepo.insertScore(currentStudent,newScore); 
	return  new CallStatus(true,"Succefully added student score");
	
	
}
 
 
 
 


    
}







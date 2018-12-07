package com.studentsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentsapi.model.Student;
//import com.studentsapi.service.impl.studentServiceImpl;
import com.studentsapi.service.impl.studentServiceImpl;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

	@Autowired // This means to get the bean called userRepository
	private studentServiceImpl studentsRepo;
    private static final String template = "Hello, %s!";
    
    @GetMapping("/api/student")
    public Student student(@RequestParam(value="name", defaultValue="World") String name) {
        return new Student("Aya",
                            String.format(template, name));
    }
    
  @GetMapping("/api/add/new/students") // Map ONLY GET Requests
  public @ResponseBody String addNewUser (@RequestParam String name
  		, @RequestParam String email) {
// 	 @ResponseBody means the returned String is the response, not a view name
//  	 @RequestParam means it is a parameter from the GET or POST request

 	Student n = new Student("Andre","Codex.gmail.com"); 
  	 System.out.println(n);
  	n.setName(name);
  	n.setEmail(email);
  	studentsRepo.insert(n);
  	return "Saved";
  }
    
  
@RequestMapping("/api/findById")
public String findById(@RequestParam("id") int id) {
	String result ="";
	result = studentsRepo.getStudentById(id);
	
	return result;
}
    
}











//@GetMapping(path="/all")
//public  Object getAllUsers() {
//	// This returns a JSON or XML with the users
//	return studentsRepo.loadAllStudents();
//}



//@RequestMapping("/findbyName")
//public String fetchDataByLastName(@RequestParam("name") String name) {
//	String result ="";
//	for (User current : userRepository.findByName(name)) {
//		result = current.toString();
//	}
//	return result;
//}


//}


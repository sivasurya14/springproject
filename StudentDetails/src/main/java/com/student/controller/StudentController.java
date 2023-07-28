package com.student.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.exceptionhandler.AgeNotEligibleException;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	static Logger log = Logger.getLogger(StudentController.class);

	@PostMapping("/saveStudentDetails")
	public String saveStudentDetails(@RequestBody Student student) throws AgeNotEligibleException, Exception {
		PropertyConfigurator.configure("log4j.properties");
		return studentService.saveStudentDetails(student);

	}
    @PostMapping("/saveStudentsDetails")
    
    public String saveStudentsDetails(@RequestBody List<Student> student) throws AgeNotEligibleException, Exception{
    	return studentService.saveStudenstDetails(student);
    }
	
    @GetMapping("/getStudentsDetails")  
    public List<Student>  getStudentsDetails(){
    	PropertyConfigurator.configure("log4j.properties");
    	log.info(studentService.getStudentDetails());  	
    	return studentService.getStudentDetails();
    }
     
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
    	PropertyConfigurator.configure("log4j.properties");
    	log.info(studentService.deleteStudentById(id)); 
    	return studentService.deleteStudentById(id);
    }
    
    
    @PutMapping("/update")
    public String updateStudentById( @RequestBody Student student) { 
    	PropertyConfigurator.configure("log4j.properties");
    	log.info(studentService.updateStudentById(student)); 
    	return studentService.updateStudentById(student);
    }
    
    @GetMapping("/getDetailsRollNo/{rollno}")
    public List<Student> getNameByRollNo(@PathVariable int rollno) {
    	PropertyConfigurator.configure("log4j.properties");
    	log.info(studentService.getNameByRollNo(rollno));  
    	return studentService.getNameByRollNo(rollno);
    }
    
    @PatchMapping("/updateName/{id}")
     public String updateName(@PathVariable int id , @RequestBody Student st) {
    	return studentService.updateName(id, st);
    }
    
}

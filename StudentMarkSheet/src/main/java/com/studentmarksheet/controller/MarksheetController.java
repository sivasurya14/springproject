package com.studentmarksheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentmarksheet.StudentMarkSheetApplication;
import com.studentmarksheet.entity.MarkSheet;
import com.studentmarksheet.service.MarksheetService;

@RestController
public class MarksheetController {
	
	@Autowired
	MarksheetService marksheetService;
	
	@PostMapping("/saveStudentsMarks")	
	public String saveStudentsMarks(@RequestBody List<MarkSheet> marks) {
		return marksheetService.saveMarksheet(marks);
	}
	@PostMapping("/saveSingleStudentsMarks")	
	public String saveStudentsMarks(@RequestBody MarkSheet marks) {
		return marksheetService.saveSingleMarksheet(marks);
	}
	
	@GetMapping("/getStudentMarksheets")
	public List<MarkSheet> getStudentMarkseet(){
		return marksheetService.getStudentMarksheet();
	}
	
	@GetMapping("/getMarksheetByRollNo/{rollno}")	
	public List<MarkSheet> getMarksheetByRollNo(@PathVariable int rollno){
		return marksheetService.getMarksheetByRollno(rollno);
	}
	
}

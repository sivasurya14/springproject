package com.studentresults.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentresults.entity.StudentResults;
import com.studentresults.service.StudentResultService;

@RestController
public class StudentResultController {

	@Autowired
	StudentResultService resultService;

	@PostMapping("/saveStudentRollNumbers")
	public String saveStudentMarks(@RequestBody StudentResults students) {
		return resultService.SaveStudentMarks(students);

	}

	@GetMapping("/getMarks")
	public List<StudentResults> getStudentsMarks() {
		return resultService.getStudentsMarks();
	}

	@DeleteMapping("/deleteMarks/{id}")
	public String deleteMarksByID(@PathVariable int id) {
		return resultService.deleteMarkById(id);
	}
	

	@PostMapping("/saveResult")
	public String saveStudentResult(@RequestBody StudentResults student) {
		return resultService.SaveStudentResult(student);
	}

	@GetMapping("/getTopper")
	public StudentResults getTopper() {
		return resultService.getTopper();
	}

	@GetMapping("/getTopThreeRanks")
	public List<StudentResults> getTopThreeRankStudents() {
		return resultService.getTopThreeRanks();
	}

	@GetMapping("/getAverageMark")
	public List<StudentResults> getAvergeStudents() {
		return resultService.getAverageMarks();
	}

}

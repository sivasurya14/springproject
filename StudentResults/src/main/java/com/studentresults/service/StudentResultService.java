package com.studentresults.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.studentresults.dao.StudentResultDao;
import com.studentresults.entity.StudentEntity;
import com.studentresults.entity.StudentMarksEntity;
import com.studentresults.entity.StudentResults;

@Service
public class StudentResultService {

	@Autowired
	StudentResultDao resultDao;

	@Autowired
	RestTemplate rest;

	public String SaveStudentMarks(StudentResults student) {
		return resultDao.saveStudentsMarks(student);
	}

	public List<StudentResults> getStudentsMarks() {
		return resultDao.getStudentsMarks();
	}

	public String deleteMarkById(int id) {
		return resultDao.deleteMarks(id);
	}

	public String updateMarkById(StudentResults student) {
		return resultDao.UpdateMarks(student);
	}
	
	public String SaveStudentResult(StudentResults student) {

		String marks = "http://localhost:8082/getMarksheetByRollNo/";
		String studentDetails = "http://localhost:8080/student/getDetailsRollNo/";

		int rollno = student.getRollNumber();
		
        //Converting Students Details URL into value 
		ResponseEntity<List<StudentEntity>> response = rest.exchange(studentDetails + rollno, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<StudentEntity>>() {
				});

		List<StudentEntity> list = response.getBody();
		for (StudentEntity val : list) {

		//Converting Mark URL into value
			ResponseEntity<List<StudentMarksEntity>> response2 = rest.exchange(marks + rollno, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<StudentMarksEntity>>() {
					});

			List<StudentMarksEntity> markslist = response2.getBody();

			for (StudentMarksEntity val2 : markslist) {

				// Set Total Marks,Roll no, Names and Percentage of the Students

				student.setName(val.getName());
				student.setRollNumber(student.getRollNumber());
				student.setTotalMark((val2.getSem1Total() + val2.getSem2Total()) / 2);
				int percentage = (student.getTotalMark() * 100) / 100;
				student.setPercentage(percentage);

				// Check the Attendence and add 5 Marks to Total Marks

				if (val.getAttendence() > 90 && student.getTotalMark() < 95) {
					student.setTotalMark(student.getTotalMark() + 5);
					int percentage2 = student.getTotalMark() * 100 / 100;
					student.setPercentage(percentage2);
				}
			}
		}
		resultDao.saveStudentsMarks(student);
		return "Data Saved successfully";
	}

	public StudentResults getTopper() {
		StudentResults topper = resultDao.getTopper().stream()
				.max(Comparator.comparingInt(StudentResults::getTotalMark)).get();
		return topper;

	}

	public List<StudentResults> getTopThreeRanks() {
		List<StudentResults> top3Ranks = resultDao.getStudentsMarks().stream()
				.sorted(Comparator.comparingInt(StudentResults::getTotalMark).reversed()).limit(3).collect(Collectors.toList());
		return top3Ranks;
	}

	public List<StudentResults> getAverageMarks() {
		List<StudentResults> averagemarkstudents = resultDao.getStudentsMarks().stream()
				.filter(x -> x.getTotalMark() > 70 && x.getTotalMark() < 90).toList();
		return averagemarkstudents;
	}
}

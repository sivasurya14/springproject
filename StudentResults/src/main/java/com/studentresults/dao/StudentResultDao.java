package com.studentresults.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentresults.entity.StudentResults;
import com.studentresults.repository.StudentResultRepo;

@Repository
public class StudentResultDao {

	@Autowired
	StudentResultRepo resultRepo;

	public String saveStudentsMarks(StudentResults student) {
		resultRepo.save(student);
		return "Data Saved Successfully";
	}

	public List<StudentResults> getStudentsMarks() {
		return resultRepo.findAll();

	}

	public String deleteMarks(int id) {
		resultRepo.deleteById(id);
		return "deleted data successfully";
	}

	public String UpdateMarks(StudentResults student) {
		resultRepo.save(student);
		return "Data Updated Successfully";
	}

	public StudentResults saveStudentMarksheet(StudentResults student) {
		return resultRepo.save(student);
	}

	public List<StudentResults> getTopper() {
		return resultRepo.findAll();
	}

}

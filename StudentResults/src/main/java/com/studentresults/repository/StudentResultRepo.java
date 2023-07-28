package com.studentresults.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentresults.entity.StudentResults;

public interface StudentResultRepo extends JpaRepository<StudentResults, Integer> {
	
	

}

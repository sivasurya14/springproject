package com.studentmarksheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentmarksheet.entity.MarkSheet;

public interface MarksheetRepo extends JpaRepository<MarkSheet, Integer>{
	
	
	@Query(value="SELECT * FROM mark_sheet where roll_number=?",nativeQuery = true)
	public List<MarkSheet> getMarksheetByRollNo(int rollno);

}

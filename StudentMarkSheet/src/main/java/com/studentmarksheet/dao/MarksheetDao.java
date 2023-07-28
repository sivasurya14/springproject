package com.studentmarksheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentmarksheet.entity.MarkSheet;
import com.studentmarksheet.repository.MarksheetRepo;

@Repository
public class MarksheetDao {

	@Autowired
	MarksheetRepo marksheetRepo;

	public List<MarkSheet> saveMarksheet(List<MarkSheet> mark) {
		return marksheetRepo.saveAll(mark);

	}

	public String saveSingleMarksheet(MarkSheet mark) {
		marksheetRepo.save(mark);
		return "Data Saved Successfully";

	}
	
	public List<MarkSheet> getStudentMarksheet(){
		return marksheetRepo.findAll();
	}
	
	public List<MarkSheet> getMarksheetByRollno(int rollno){
		return marksheetRepo.getMarksheetByRollNo(rollno);
	}
}

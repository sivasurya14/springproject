package com.studentmarksheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import com.studentmarksheet.dao.MarksheetDao;
import com.studentmarksheet.entity.MarkSheet;

@Service
public class MarksheetService {

	@Autowired
	MarksheetDao marksheetDao;

	public String saveMarksheet(List<MarkSheet> marks) {
		for (MarkSheet mark : marks) {
			mark.setSem1Total(mark.getSem1Practicals() + mark.getSem1Theory());
			mark.setSem2Total(mark.getSem2Practicals() + mark.getSem2Theory());
		}
		marksheetDao.saveMarksheet(marks);
		return "Data Saved Successfully";
	}

	public String saveSingleMarksheet(MarkSheet mark) {
		mark.setSem1Total(mark.getSem1Practicals() + mark.getSem1Theory());
		mark.setSem2Total(mark.getSem2Practicals() + mark.getSem2Theory());
        
	return	marksheetDao.saveSingleMarksheet(mark);
	
	}
	
	public List<MarkSheet>  getStudentMarksheet() {		
		return  marksheetDao.getStudentMarksheet();
	}
	
	public List<MarkSheet>  getMarksheetByRollno(int rollno){
		return marksheetDao.getMarksheetByRollno(rollno);
	}
}

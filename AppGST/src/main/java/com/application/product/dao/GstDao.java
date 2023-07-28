package com.application.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.product.entity.GstEntity;
import com.application.product.exception.PercentageException;
import com.application.product.repo.GstRepo;

@Repository
public class GstDao {
	
	@Autowired
	GstRepo gstRepo;
	
	    public String saveGst(GstEntity gst) throws PercentageException, Exception {
		gstRepo.save(gst);
		return "Data saved Successfully";
		
	}
	
	 public String saveGst(List<GstEntity> gs) {
		 gstRepo.saveAll(gs);
		 return "Data Saved successfully";
	 }

	 public int getPercentage(int hsn) {
		 return gstRepo.getPercentByHsn(hsn);
	 }
}

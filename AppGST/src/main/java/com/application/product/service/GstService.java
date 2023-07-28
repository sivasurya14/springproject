package com.application.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.product.dao.GstDao;
import com.application.product.entity.GstEntity;
import com.application.product.exception.PercentageException;

@Service
public class GstService {

	@Autowired
	GstDao gsDao;
	
	public String saveGST(GstEntity gst) throws PercentageException,Exception {
		
		if(gst.getPercentage()>30) {
			 throw new PercentageException("percentage should not be above 30");
		}else {
			return  gsDao.saveGst(gst);
		}	
	}
	
	
	public String saveGst(List<GstEntity> ge) {		
		return gsDao.saveGst(ge);
	}
	
	public int getpercentByHsn(int hsn) {
		return gsDao.getPercentage(hsn);
	}
	
}

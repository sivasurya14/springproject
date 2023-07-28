package com.application.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.product.entity.GstEntity;
import com.application.product.exception.PercentageException;
import com.application.product.service.GstService;


@RestController
public class GstController {
	
	@Autowired
	GstService gstService;
	
	@PostMapping("/saveGST")
	public String saveGST(@RequestBody GstEntity gst) throws PercentageException, Exception {
		return gstService.saveGST(gst);
	}
	
	
	@PostMapping("/saveGst")
	public String saveGst(@RequestBody List<GstEntity> gs) {		
		return gstService.saveGst(gs);
	}
	
	@GetMapping("/gstPercentageByHsn/{hsn}")
	public int getPercentByHsn(@PathVariable int hsn) {	
	return gstService.getpercentByHsn(hsn);
	
	}

}

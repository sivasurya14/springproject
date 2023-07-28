package com.application.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.application.product.entity.GstEntity;

public interface GstRepo extends JpaRepository<GstEntity, Integer> {
	
	@Query(value="select * from gst_table where hsn= ?", nativeQuery = true)
	public int  getPercentByHsn(int hsn) ;
	
	}



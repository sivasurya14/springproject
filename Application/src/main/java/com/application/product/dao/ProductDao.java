package com.application.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.product.entity.ProductsEntity;
import com.application.product.repo.ProductRepo;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepo productRepo;
	
	
	public String  saveProducts(List<ProductsEntity> pe){		
     productRepo.saveAll(pe);    
     return "Data saved Successfully";		
	}

	public List<ProductsEntity> getProducts(){		
		return productRepo.findAll();
	}
	
	public ProductsEntity findByID(int hsn) {
		return productRepo.findById(hsn).get();
	}
	
	public List<ProductsEntity> findProductsByHSN(int hsn) {
		return productRepo.getProductsByHsn(hsn);
	}
}

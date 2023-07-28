package com.application.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.product.dao.ProductDao;
import com.application.product.entity.ProductsEntity;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public String saveProducts(List<ProductsEntity> pe){		
		return productDao.saveProducts(pe);
		
	}
	
	public List<ProductsEntity>  getAllProducts(){		
		return productDao.getProducts();
	}
	
	public ProductsEntity findByID(int hsn) {
		return productDao.findByID(hsn);
	}

	public List<ProductsEntity> findProductsByHSN(int hsn){		
		return productDao.findProductsByHSN(hsn);
	}
	
	
	
	}

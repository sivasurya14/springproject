package com.application.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.application.product.entity.ProductsEntity;

public interface ProductRepo extends JpaRepository<ProductsEntity, Integer> {

	
	
	  @Query(value="select * from products_table where hsn=?",nativeQuery =true )
	  public List<ProductsEntity> getProductsByHsn( int hsn);
}

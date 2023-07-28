package com.flipkart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	
	@Query(value ="select ot.city , pt.name from order_table ot join product_table  pt on ot.order_id=pt.order_fk", nativeQuery = true )
	public  List<Object> getList ();
	
	
	

	
}

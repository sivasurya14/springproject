package com.flipkart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

	@Autowired
	OrderRepository orderRepo;

	public OrderEntity saveOrderDetails(OrderEntity order) {

		return orderRepo.save(order);

	}

     public List<Object> getOrderDetails(){
    	 return orderRepo.getList();
     }
}

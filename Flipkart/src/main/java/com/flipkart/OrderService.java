package com.flipkart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	public String savOrderDetails(OrderEntity order) {
		
		orderDao.saveOrderDetails(order);
		return "Data saved Successfully";
	}

	public List<Object> getList(){
		return orderDao.getOrderDetails();
	}
}

package com.flipkart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	
	@PostMapping("/saveOrderDetaails")
	public String  saveOrderDetails(@RequestBody OrderEntity order) {
		return orderservice.savOrderDetails(order);
	}
	
	@GetMapping("/getListOfProducts")
	
	public List<Object> getListOfOrders(){
		return orderservice.getList();
	}
	
}

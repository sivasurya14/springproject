package com.application.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.gst.entity.ProductsEntity;

@RestController
public class Gst_Calculation_Controller {
   @Autowired
   RestTemplate rest;
	
	@GetMapping("/getProdcutsPriceWithGst")
	
	public List<ProductsEntity> getPercentageWithGst(){
		
		String url1="http://localhost:8080/products/getAllProducts";
		String url2="http://localhost:8081/gstPercentageByHsn/";
		
		ResponseEntity<List<ProductsEntity>> response1 =rest.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductsEntity>>(){
		});
		
		List<ProductsEntity> product=response1.getBody();
		 
		for(ProductsEntity p : product) {
			int hsn=p.getHsn();
			
			ResponseEntity<Integer> response2=rest.exchange(url2+hsn, HttpMethod.GET, null, Integer.class);
			int percentage=response2.getBody();	
			
			p.setPrice(p.getPrice()+p.getPrice()*percentage/100);
			
			
		}
		return product;
	}
}

package com.studentmarksheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestController2 {
	
	@Autowired	
	RestTemplate rest;
	
	@GetMapping("/getMessage")
	
	
	public String getResponse(){
		String url = "http://localhost:8080/message";
		ResponseEntity<String> response =rest.exchange(url, HttpMethod.GET, null, String.class);
		
//		ResponseEntity<String> response= rest
		
		 String a=response.getBody();		
		 return a;
		
	}
	

}

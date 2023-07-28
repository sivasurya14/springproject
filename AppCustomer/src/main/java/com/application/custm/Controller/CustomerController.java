package com.application.custm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.custm.entity.CustomerEntity;
import com.application.custm.repo.CustomerRepo;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	RestTemplate rest;
	
	@PostMapping("/saveCustomerDetails")
	public String saveData (@RequestBody CustomerEntity ce) {
			
		String url1="http://localhost:8080/getIfscCode/";		
		ResponseEntity<String> response =rest.exchange(url1+ce.getBranch(), HttpMethod.GET, null, String.class);			
		      String ifsc=response.getBody();
		      
			ce.setIfscCode(ifsc);  	
			customerRepo.save(ce);
		return "data saved successfully";
	 				
	}
	
   @PostMapping("/saveListOfCustomerDetails")  
   public String saveCustomerInfo(@RequestBody List<CustomerEntity> ce) {
	   
	   String url1="http://localhost:8080/getIfscCode/";
	   
	   for(CustomerEntity p : ce) {	
		String branch=  p.getBranch();	
		ResponseEntity<String> response =rest.exchange(url1+ branch, HttpMethod.GET, null, String.class);		
	      String ifsc=response.getBody();
	      p.setIfscCode(ifsc);
	       	      
	   }

	   
	    customerRepo.saveAll(ce);
		return "data saved successfully";	   
   }  
   @GetMapping("/getCustomerDetails")  
   public List<CustomerEntity> getCustomer(){	   
	   return customerRepo.findAll();
   }
   
}

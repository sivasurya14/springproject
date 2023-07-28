package com.amazon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonController {
	
	
	@GetMapping("/getProduct")
	public String getProduct() {
		return "Welcome to Login Page";
	}

}

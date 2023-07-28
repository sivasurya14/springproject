package com.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AmazonController {
	@Autowired
	RestTemplate rest;

	@GetMapping("/get")
	public String getProduct() {

		String url = "http://localhost:8082/getProduct";

		ResponseEntity<String> res = rest.exchange(url, HttpMethod.GET, null, String.class);

		String val = res.getBody();

		return val;

	}

}

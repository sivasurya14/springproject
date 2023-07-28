package com.restemplate;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

	RestTemplate rest = new RestTemplate();

	@GetMapping("/getMessageviaCustomer")

	public String getMessage() {

		String url = "http://localhost:8080/getMessage";

		ResponseEntity<String> respone = rest.exchange(url, HttpMethod.GET, null, String.class);

		String value = respone.getBody();

		return value;
	}

}

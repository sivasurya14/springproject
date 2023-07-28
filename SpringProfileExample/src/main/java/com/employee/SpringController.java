package com.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

	@Value("${value}")
	private String a;

	@GetMapping("/getMessage")
	public String getMessage() {
		return "this" + a;
	}
}

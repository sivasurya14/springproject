package com.studentmarksheet;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("/message")	
	public String showMessage() {		
		return "hello java ";
	}

}

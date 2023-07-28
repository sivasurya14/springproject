package com.onesoft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnesoftController {
	
	
	@GetMapping("/student")
	public String getStudents() {
		return "this is student method";
	}

	@GetMapping("/trainer")
	public String getTrainers() {
		return "this is trainner";
	}
	
	@GetMapping("/manager")
	public String getManagers() {
		return "This is manager method";
	}
}
